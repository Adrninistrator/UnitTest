package test.testmock.static1.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPrivateNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//执行真实方法
public class TestStPrNVThenCallRealMethod extends TestStaticPrivateNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrNVThenCallRealMethod.class);

    //通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1);

        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito.eq
                (TestConstants.FLAG1), Mockito.any(TestTableEntity.class)).thenCallRealMethod();

        //通过反射执行私有方法
        String str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,
                TestConstants.FLAG2, new TestTableEntity());
        //不满足thenCallRealMethod的参数条件，返回数据应为null
        logger.info("TestStaticPrivateNonVoid1.test1 (TestConstants.FLAG2, new TestTableEntity()): {}", str);
        Assert.assertNull(str);

        //真实方法执行次数应为0
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));

        //通过反射执行私有方法
        str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,
                TestConstants.FLAG1, new TestTableEntity());
        //满足thenCallRealMethod的参数条件，返回数据应为原始值
        logger.info("TestStaticPrivateNonVoid1.test1 (TestConstants.FLAG1, new TestTableEntity()): {}", str);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行次数应为1
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }

    //通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1);

        //指定公有方法执行真实方法
        Mockito.when(TestStaticPrivateNonVoid1.testPublic1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito.anyString(),
                Mockito.any(TestTableEntity.class)).thenCallRealMethod();

        //通过公有方法执行私有方法
        String str = TestStaticPrivateNonVoid1.testPublic1(TestConstants.FLAG1, new TestTableEntity());
        //满足thenCallRealMethod的参数条件，返回数据应为原始值
        logger.info("TestStaticPrivateNonVoid1.testPublic1 (TestConstants.FLAG1, new TestTableEntity()): {}", str);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行次数应为1
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));

        //通过公有方法执行私有方法
        str = TestStaticPrivateNonVoid1.testPublic1("", new TestTableEntity());
        //满足thenCallRealMethod的参数条件，返回数据应为原始值
        logger.info("TestStaticPrivateNonVoid1.testPublic1 (\"\", new TestTableEntity()): {}", str);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行次数应为2
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }

}
