package test.testmock.spring.spy.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class TestSpSPrVThenThrow extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateVoidService1Spy,
                TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer.class));

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer());
    }
}
