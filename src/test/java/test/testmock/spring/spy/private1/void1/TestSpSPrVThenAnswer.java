package test.testmock.spring.spy.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;

public class TestSpSPrVThenAnswer extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.doAnswer(invocation -> {

            StringBuffer arg = TestCommonUtil.getMockArg(invocation, 0, StringBuffer.class);

            arg.setLength(0);
            arg.append(TestConstants.MOCKED);

            return null;
        }).when(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer.class));


        StringBuffer stringBuffer = new StringBuffer();

        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
