package test.testmock.spring.mock.private1.void1;

import com.test.service.impl.TestPrivateVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

//使用verify判断方法的执行次数
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVVerify extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl.class);

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(0));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        //执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer());

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        //执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer());

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        //Whitebox.invokeMethod未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));

    }
}
