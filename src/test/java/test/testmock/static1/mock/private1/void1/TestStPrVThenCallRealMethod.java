package test.testmock.static1.mock.private1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//执行真实方法，Stub条件使用Mockito.any(StringBuffer.class)
public class TestStPrVThenCallRealMethod extends TestStaticPrivateVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrVThenCallRealMethod.class);

    //通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenCallRealMethod();

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG1);

        //执行TestStaticPrivateVoid1.test1
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuffer);
        //执行TestStaticPrivateVoid1.test1方法，满足thenCallRealMethod的参数条件，调用参数应为真实方法处理后的值
        logger.info("TestStaticPrivateVoid1.test1 (TestConstants.FLAG1) thenCallRealMethod: {}", stringBuffer);
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, stringBuffer.toString());

        //真实方法执行次数应为1
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }

    //通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        //指定公有方法执行真实方法
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TESTPUBLIC1, Mockito.any
                (StringBuffer.class)).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenCallRealMethod();

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG1);

        //执行TestStaticPrivateVoid1.test1
        TestStaticPrivateVoid1.testPublic1(stringBuffer);
        //执行TestStaticPrivateVoid1.testPublic1方法，满足thenCallRealMethod的参数条件，调用参数应为真实方法处理后的值
        logger.info("TestStaticPrivateVoid1.testPublic1 (TestConstants.FLAG1) thenCallRealMethod: {}", stringBuffer);
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, stringBuffer.toString());

        //真实方法执行次数应为1
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }


}
