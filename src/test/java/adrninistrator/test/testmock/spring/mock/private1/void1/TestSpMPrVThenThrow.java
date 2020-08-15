package adrninistrator.test.testmock.spring.mock.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVThenThrow extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl
                .class);

        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateVoidService1,
                TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuilder.class));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
