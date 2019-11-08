package test.testmock.spring.spy.private1.void1;

import com.test.service.impl.TestPrivateVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class TestSpSPrVVerify extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(0));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        //执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer());

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        //执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer());

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        //真实方法执行了两次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));
    }
}
