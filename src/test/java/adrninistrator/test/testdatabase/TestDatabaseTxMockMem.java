package adrninistrator.test.testdatabase;

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
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.*;

// 将使用事务的类的实例的Mapper对象进行替换，测试使用事务时出现异常回滚
public class TestDatabaseTxMockMem extends TestMockBase {

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

    @Test
    public void testWithTx() {
        String id = TestIdGen.genId();

        // TestTxService1Impl.test()方法执行第二次数据库操作出现异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testTxService1.withTx(id)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 使用了事务，执行的第一次数据库插入操作回滚，查询数据不存在
        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNull(testTableEntity);
    }

    @Test
    public void testWithOutTx() {
        String id = TestIdGen.genId();

        // TestTxService1Impl.test()方法执行第二次数据库操作出现异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testTxService1.withOutTx(id)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 未使用事务，执行的第一次数据库插入操作未回滚，查询数据存在
        TestTableEntity testTableEntity = testTxService1.select(id);
        assertNotNull(testTableEntity);
        assertEquals(TestConstants.FLAG1, testTableEntity.getFlag());
    }
}
