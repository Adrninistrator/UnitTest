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

// 修改返回值
@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public class TestSpMPrNVThenReturn extends TestMockBase {

    @Test
    public void test1() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        PowerMockito.doReturn(TestConstants.MOCKED).when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl
                .NAME_TEST1, Mockito.anyString());

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        Mockito.when(testPrivateNonVoidService1.testPublic1(Mockito.anyString())).thenCallRealMethod();
        PowerMockito.doReturn(TestConstants.MOCKED).when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl
                .NAME_TEST1, Mockito.anyString());

        String str = testPrivateNonVoidService1.testPublic1("");

        assertEquals(TestConstants.MOCKED, str);
    }
}
