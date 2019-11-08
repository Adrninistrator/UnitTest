package test.testmock.spring.mock.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

//抛出异常
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVThenThrow extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl
                .class);

        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateVoidService1,
                TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer.class));

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuffer());
    }
}
