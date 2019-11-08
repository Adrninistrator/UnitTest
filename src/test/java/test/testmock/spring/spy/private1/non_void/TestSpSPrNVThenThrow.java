package test.testmock.spring.spy.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class TestSpSPrNVThenThrow extends TestSpringSpyPrivateNonVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPrivateNonVoidService1Spy,
                TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito.anyString());

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        Whitebox.invokeMethod(testPrivateNonVoidService1Spy, TestPrivateNonVoidService1Impl.NAME_TEST1,
                "");
    }
}
