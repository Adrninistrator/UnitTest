package adrninistrator.test.testmock.spring.spy.private1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestSpSPrVThenCallRealMethod extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateVoidService1Impl.class, TestPrivateVoidService1Impl.NAME_TEST1);

        PowerMockito.doCallRealMethod().when(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuilder.class));

        // 未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));

        StringBuilder stringBuilder = new StringBuilder();

        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        // 真实方法执行了1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));
    }
}
