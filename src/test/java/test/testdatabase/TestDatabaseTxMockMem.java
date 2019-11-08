package test.testdatabase;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestTxService1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockBase;

import java.util.concurrent.atomic.AtomicInteger;

//将使用事务的类的实例的成员变量进行替换
public class TestDatabaseTxMockMem extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestDatabaseTxMockMem.class);

    @Autowired
    private TestTxService1 testTxService1;

    @Autowired
    private TestTableMapper testTableMapper;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Before
    public void init() {

        TestTableMapper testTableMapperMock = Mockito.mock(TestTableMapper.class);

        Mockito.when(testTableMapperMock.insert(Mockito.any(TestTableEntity.class))).thenAnswer(invocation -> {
            TestTableEntity arg1 = TestCommonUtil.getMockArg(invocation, 0, TestTableEntity.class);
            return testTableMapper.insert(arg1);
        });

        //对TestTxService1Impl类中的TestTableMapper对象的updateByPrimaryKeySelective方法进行Stub，使TestTableMapper.test()方法在执行第二次数据库操作时出现异常
        Mockito.when(testTableMapperMock.updateByPrimaryKeySelective(Mockito.any(TestTableEntity.class))).thenThrow
                (new RuntimeException(TestConstants.MOCKED));

        Mockito.when(testTableMapperMock.selectByPrimaryKey(Mockito.anyString())).thenAnswer(invocation -> {
            String arg1 = TestCommonUtil.getMockArg(invocation, 0, String.class);
            return testTableMapper.selectByPrimaryKey(arg1);
        });

        TestTxService1 testTxService1Raw = AopTestUtils.getTargetObject(testTxService1);

        Whitebox.setInternalState(testTxService1Raw, testTableMapperMock);
    }

    @Test
    public void test1() {

        String id = genId();

        //TestTxService1Impl.test()方法执行第二次数据库操作出现异常
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        try {
            testTxService1.withTx(id);
        } catch (Exception e) {

            //使用了事务，执行的第一次数据库操作回滚，查询数据不存在
            TestTableEntity testTableEntity = testTxService1.select(id);
            Assert.assertNull(testTableEntity);

            throw e;
        }
    }

    @Test
    public void test2() {

        String id = genId();

        //TestTxService1Impl.test()方法执行第二次数据库操作出现异常
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        try {
            testTxService1.withOutTx(id);
        } catch (Exception e) {

            //使用了事务，执行的第一次数据库操作未回滚，查询数据存在
            TestTableEntity testTableEntity = testTxService1.select(id);
            Assert.assertNotNull(testTableEntity);
            Assert.assertEquals(TestConstants.FLAG1, testTableEntity.getFlag());

            throw e;
        }
    }

    private String genId() {

        String id = System.currentTimeMillis() + TestConstants.MINUS + atomicInteger.incrementAndGet();

        logger.info("genId: {}", id);

        return id;
    }
}
