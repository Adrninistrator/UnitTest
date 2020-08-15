package adrninistrator.test.testmock.spring.spy.private1.void1;

import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

public class TestSpSPrVVerify extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateVoidService1Impl.class, TestPrivateVoidService1Impl.NAME_TEST1);

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(0));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        // 执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder());

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        // 执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder());

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        // 真实方法执行了两次
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));
    }
}
