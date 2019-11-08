package test.testmock.spring.spy.private1.non_void;

import com.test.service.impl.TestPrivateNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class TestSpSPrNVVerify extends TestSpringSpyPrivateNonVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.verifyPrivate(testPrivateNonVoidService1Spy, Mockito.times(0));
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //执行testPrivateNonVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        PowerMockito.verifyPrivate(testPrivateNonVoidService1Spy, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //执行testPrivateNonVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        PowerMockito.verifyPrivate(testPrivateNonVoidService1Spy, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //真实方法执行了两次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));
    }
}
