package adrninistrator.test.testmock.spring.spy.private1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestSpSPrNVThenCallRealMethod extends TestSpringSpyPrivateNonVoidBase {

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateNonVoidService1Impl.class, TestPrivateNonVoidService1Impl.NAME_TEST1);

        PowerMockito.doCallRealMethod().when(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1,
                Mockito.any(StringBuilder.class));

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        assertEquals(TestConstants.NOT_MOCKED, str);

        // 真实方法执行了1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));
    }
}
