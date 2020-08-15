package adrninistrator.test.testmock.spring.mock.private1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.impl.TestPrivateNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 使用verify判断方法的执行次数，使用Mockito.verify时会出现问题
public class TestSpMPrNVVerifyMockito extends TestMockBase {

    // Mockito.verify执行一次正常，执行一次以上出现异常
    @Test
    public void test() throws Exception {
        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = Mockito.mock(TestPrivateNonVoidService1Impl.class);

        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        // Whitebox.invokeMethod执行了真实方法
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        Mockito.verify(testPrivateNonVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        // Whitebox.invokeMethod执行了真实方法
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        // 应出现指定异常
        assertThrows(Exception.class, () ->
                Mockito.verify(testPrivateNonVoidService1, Mockito.times(1))
        );
    }
}
