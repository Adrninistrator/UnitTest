package test.testmock.spring.spy.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import java.util.List;

public class TestSpSPrVVerifyCaptor extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        ArgumentCaptor<StringBuffer> argCaptor1a = ArgumentCaptor.forClass(StringBuffer.class);

        //执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer()
                .append(TestConstants.FLAG1));

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1a.capture());

        check1(argCaptor1a);

        //执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer()
                .append(TestConstants.FLAG2));

        ArgumentCaptor<StringBuffer> argCaptor1b = ArgumentCaptor.forClass(StringBuffer.class);

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1b.capture());

        check2(argCaptor1b);

        //真实方法执行了两次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));
    }

    //真实方法会执行，调用参数值会被修改
    private void check1(ArgumentCaptor<StringBuffer> argCaptor1) {

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, argCaptor1.getValue().toString());

        List<StringBuffer> args = argCaptor1.getAllValues();

        Assert.assertEquals(1, args.size());
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, args.get(0).toString());
    }

    private void check2(ArgumentCaptor<StringBuffer> argCaptor1) {

        Assert.assertEquals(TestConstants.FLAG2 + TestConstants.NOT_MOCKED, argCaptor1.getValue().toString());

        List<StringBuffer> args = argCaptor1.getAllValues();

        Assert.assertEquals(2, args.size());
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, args.get(0).toString());
        Assert.assertEquals(TestConstants.FLAG2 + TestConstants.NOT_MOCKED, args.get(1).toString());
    }
}
