package test.testmock.spring.mock.private1.non_void;

import com.test.service.impl.TestPrivateNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

//使用verify判断方法的执行次数
@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public class TestSpMPrNVVerify extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        PowerMockito.verifyPrivate(testPrivateNonVoidService1, Mockito.times(0));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //执行testPrivateNonVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        PowerMockito.verifyPrivate(testPrivateNonVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //执行testPrivateNonVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        PowerMockito.verifyPrivate(testPrivateNonVoidService1, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito
                .anyString());

        //Whitebox.invokeMethod未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));
    }
}
