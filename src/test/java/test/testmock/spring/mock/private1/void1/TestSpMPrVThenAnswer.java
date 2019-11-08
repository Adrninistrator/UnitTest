package test.testmock.spring.mock.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockBase;

//使用Answer实现回调
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVThenAnswer extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl
                .class);

        PowerMockito.doAnswer(invocation -> {

            StringBuffer arg = TestCommonUtil.getMockArg(invocation, 0, StringBuffer.class);

            arg.setLength(0);
            arg.append(TestConstants.MOCKED);

            return null;
        }).when(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1,
                stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
