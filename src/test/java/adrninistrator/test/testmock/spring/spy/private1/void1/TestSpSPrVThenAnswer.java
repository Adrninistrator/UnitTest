package adrninistrator.test.testmock.spring.spy.private1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

public class TestSpSPrVThenAnswer extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateVoidService1Impl.class, TestPrivateVoidService1Impl.NAME_TEST1);

        PowerMockito.doAnswer(invocation -> {

            StringBuilder arg = invocation.getArgument(0);

            arg.setLength(0);
            arg.append(TestConstants.MOCKED);

            return null;
        }).when(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuilder.class));


        StringBuilder stringBuilder = new StringBuilder();

        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }
}
