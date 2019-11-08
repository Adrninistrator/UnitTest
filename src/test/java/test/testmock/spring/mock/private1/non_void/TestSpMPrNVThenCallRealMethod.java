package test.testmock.spring.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

//执行真实方法
@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public class TestSpMPrNVThenCallRealMethod extends TestMockBase {

    @Test
    public void test1() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        PowerMockito.doCallRealMethod().when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl
                .NAME_TEST1, Mockito.anyString());

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test2() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        Mockito.when(testPrivateNonVoidService1.testPublic1(Mockito.anyString())).thenCallRealMethod();
        PowerMockito.doCallRealMethod().when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl
                .NAME_TEST1, Mockito.anyString());

        String str = testPrivateNonVoidService1.testPublic1("");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
