package adrninistrator.test.testmock.spring.mock.private1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public class TestSpMPrNVThenThrow extends TestMockBase {

    @Test
    public void test1() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateNonVoidService1,
                TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito.anyString());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        Mockito.when(testPrivateNonVoidService1.testPublic1(Mockito.anyString())).thenCallRealMethod();
        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateNonVoidService1,
                TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito.anyString());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPrivateNonVoidService1.testPublic1("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
