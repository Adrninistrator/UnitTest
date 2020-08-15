package adrninistrator.test.testmock.spring.mock.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVVerify extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl.class);

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(0));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        // 执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder());

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        // 执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder());

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuilder.class));

        // Whitebox.invokeMethod未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));
    }
}
