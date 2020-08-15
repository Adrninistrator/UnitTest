package adrninistrator.test.testdatabase.rollback;

import adrninistrator.test.common.TestIdGen;
import adrninistrator.test.common.TestReplaceUtil;
import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestTxService1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.util.AopTestUtils;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/*
    将使用事务的类的实例的Mapper对象进行替换，测试使用事务时出现异常回滚
    由于测试类使用了事务，会导致被测试代码中的事务（propagation使用默认的REQUIRED）不生效
 */
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@Transactional
public class TestDBRB_CYTx2 extends TestMockBase {

    @Autowired
    private TestTxService1 testTxService1;

    @Autowired
    private TestTableMapper testTableMapper;

    @Before
    public void init() {
        // 使用AopTestUtils.getTargetObject获取原始对象
        TestTxService1 testTxService1Raw = AopTestUtils.getTargetObject(testTxService1);

        TestTableMapper testTableMapperMock = TestReplaceUtil.replaceMockMember(testTxService1Raw, TestTableMapper.class);

        Mockito.when(testTableMapperMock.insert(Mockito.any(TestTableEntity.class))).thenAnswer(invocation -> {
            TestTableEntity arg1 = invocation.getArgument(0);
            return testTableMapper.insert(arg1);
        });

        // 对TestTxService1Impl类中的TestTableMapper对象的updateByPrimaryKeySelective方法进行Stub，使TestTableMapper.test()方法在执行第二次数据库操作时出现异常
        Mockito.when(testTableMapperMock.updateByPrimaryKeySelective(Mockito.any(TestTableEntity.class))).thenThrow
                (new RuntimeException(TestConstants.MOCKED));

        Mockito.when(testTableMapperMock.selectByPrimaryKey(Mockito.anyString())).thenAnswer(invocation -> {
            String arg1 = invocation.getArgument(0);
            return testTableMapper.selectByPrimaryKey(arg1);
        });
    }

    /*
        以下执行的被测试方法TestTxService1Impl.withTx()使用了事务（propagation使用默认的REQUIRED），由于出现了异常，会使数据库操作回滚
        当前测试类使用了事务，以下测试方法使用了@Commit注解，在方法结束时会提交事务，会出现以下异常
        org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
     */
    @Commit
    @Test
    public void testWithTxCommitError() {
        doTestWithTx();
    }

    @Rollback
    @Test
    public void testWithTxRollback() {
        doTestWithTx();
    }

    private void doTestWithTx() {
        String id = TestIdGen.genId();

        // TestTxService1Impl.test()方法执行第二次数据库操作出现异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testTxService1.withTx(id)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 使用了事务，由于测试类级别使用了事务，导致被测试代码中的事务不生效，执行的第一次数据库插入操作未回滚，查询数据存在
        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG1, testTableEntity.getFlag());
    }
}
