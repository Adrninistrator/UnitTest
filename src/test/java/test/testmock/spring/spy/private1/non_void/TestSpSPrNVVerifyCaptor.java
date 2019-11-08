package test.testmock.spring.spy.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import java.util.List;

public class TestSpSPrNVVerifyCaptor extends TestSpringSpyPrivateNonVoidBase {

    @Test
    public void test() throws Exception {

        ArgumentCaptor<String> argCaptor1a = ArgumentCaptor.forClass(String.class);

        //执行testPrivateNonVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, TestConstants
                .FLAG1);

        PowerMockito.verifyPrivate(testPrivateNonVoidService1Spy, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1,
                argCaptor1a.capture());

        check1(argCaptor1a);

        ArgumentCaptor<String> argCaptor1b = ArgumentCaptor.forClass(String.class);

        //执行testPrivateNonVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, TestConstants
                .FLAG2);

        PowerMockito.verifyPrivate(testPrivateNonVoidService1Spy, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1,
                argCaptor1b.capture());

        check2(argCaptor1b);

        //真实方法执行了两次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));
    }

    private void check1(ArgumentCaptor<String> argCaptor1) {

        Assert.assertEquals(TestConstants.FLAG1, argCaptor1.getValue());

        List<String> args = argCaptor1.getAllValues();

        Assert.assertEquals(1, args.size());
        Assert.assertEquals(TestConstants.FLAG1, args.get(0));
    }

    private void check2(ArgumentCaptor<String> argCaptor1) {

        Assert.assertEquals(TestConstants.FLAG2, argCaptor1.getValue());

        List<String> args = argCaptor1.getAllValues();

        Assert.assertEquals(2, args.size());
        Assert.assertEquals(TestConstants.FLAG1, args.get(0));
        Assert.assertEquals(TestConstants.FLAG2, args.get(1));
    }
}
