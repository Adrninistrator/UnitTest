package test.testdatabase;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestTxService1;
import com.test.service.impl.TestTxService1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.powermock.reflect.exceptions.FieldNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestCommonUtil;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

import java.util.concurrent.atomic.AtomicInteger;

//将使用事务的类的实例的成员变量进行替换，错误方法
public class TestDatabaseTxMockMemWrong extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestDatabaseTxMockMemWrong.class);

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


        if (testTxService1.getClass().getName().contains(TestTxService1Impl.class.getSimpleName())) {
            //AOP代理对象类名中包含原始类名，说明使用CGLIB代理

            Whitebox.setInternalState(testTxService1, testTableMapperMock);

        } else {
            //AOP代理对象类名中不包含原始类名，说明使用JDK动态代理

            expectedException.expect(new TestMatcherExpClassEquals(FieldNotFoundException.class));

            Whitebox.setInternalState(testTxService1, testTableMapperMock);
        }
    }

    @Test
    public void test1() {

        String id = genId();

        //TestTxService1Impl.test()方法执行未出现异常，两次数据库操作执行完毕
        testTxService1.withTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }

    @Test
    public void test2() {

        String id = genId();

        //TestTxService1Impl.test()方法执行未出现异常，两次数据库操作执行完毕
        testTxService1.withOutTx(id);

        TestTableEntity testTableEntity = testTxService1.select(id);
        Assert.assertNotNull(testTableEntity);
        Assert.assertEquals(TestConstants.FLAG2, testTableEntity.getFlag());
    }

    private String genId() {

        String id = System.currentTimeMillis() + TestConstants.MINUS + atomicInteger.incrementAndGet();

        logger.info("genId: {}", id);

        return id;
    }
}
