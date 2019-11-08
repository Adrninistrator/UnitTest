package test.testmock.spring.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

//抛出异常
@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public class TestSpMPrNVThenThrow extends TestMockBase {

    @Test
    public void test1() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateNonVoidService1,
                TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito.anyString());

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");
    }

    @Test
    public void test2() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        Mockito.when(testPrivateNonVoidService1.testPublic1(Mockito.anyString())).thenCallRealMethod();
        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateNonVoidService1,
                TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito.anyString());

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        testPrivateNonVoidService1.testPublic1("");
    }
}
