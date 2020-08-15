package adrninistrator.test.testmock.spring.spy.private1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

public class TestSpSPrNVThenAnswer extends TestSpringSpyPrivateNonVoidBase {

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateNonVoidService1Impl.class, TestPrivateNonVoidService1Impl.NAME_TEST1);

        PowerMockito.doAnswer(invocation -> TestConstants.MOCKED).when(testPrivateNonVoidService1Spy,
                TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito.anyString());

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1,
                "");

        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));
    }
}
