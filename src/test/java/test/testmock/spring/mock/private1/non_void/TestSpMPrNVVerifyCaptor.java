package test.testmock.spring.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

import java.util.List;

//使用verify判断方法的执行次数，使用Captor获取调用参数
@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public class TestSpMPrNVVerifyCaptor extends TestMockBase {

    @Test
    public void test() throws Exception {

        ArgumentCaptor<String> argCaptor1a = ArgumentCaptor.forClass(String.class);

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        //第一次执行
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, TestConstants
                .FLAG1);

        PowerMockito.verifyPrivate(testPrivateNonVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1,
                argCaptor1a.capture());

        check1(argCaptor1a);

        ArgumentCaptor<String> argCaptor1b = ArgumentCaptor.forClass(String.class);

        //第二次执行
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, TestConstants
                .FLAG2);

        PowerMockito.verifyPrivate(testPrivateNonVoidService1, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1,
                argCaptor1b.capture());

        check2(argCaptor1b);
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
