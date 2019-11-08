package test.testmock.spring.mock.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

import java.util.List;

//使用verify判断方法的执行次数，并使用Captor获取调用参数
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVVerifyCaptor extends TestMockBase {

    @Test
    public void test() throws Exception {

        ArgumentCaptor<StringBuffer> argCaptor1a = ArgumentCaptor.forClass(StringBuffer.class);

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl
                .class);

        //执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer()
                .append(TestConstants.FLAG1));

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1a.capture());

        check1(argCaptor1a);

        //执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer()
                .append(TestConstants.FLAG2));

        ArgumentCaptor<StringBuffer> argCaptor1b = ArgumentCaptor.forClass(StringBuffer.class);

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1b.capture());

        check2(argCaptor1b);
    }

    private void check1(ArgumentCaptor<StringBuffer> argCaptor1) {

        Assert.assertEquals(TestConstants.FLAG1, argCaptor1.getValue().toString());

        List<StringBuffer> args = argCaptor1.getAllValues();

        Assert.assertEquals(1, args.size());
        Assert.assertEquals(TestConstants.FLAG1, args.get(0).toString());
    }

    private void check2(ArgumentCaptor<StringBuffer> argCaptor1) {

        Assert.assertEquals(TestConstants.FLAG2, argCaptor1.getValue().toString());

        List<StringBuffer> args = argCaptor1.getAllValues();

        Assert.assertEquals(2, args.size());
        Assert.assertEquals(TestConstants.FLAG1, args.get(0).toString());
        Assert.assertEquals(TestConstants.FLAG2, args.get(1).toString());
    }
}
