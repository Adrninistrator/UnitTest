package test.testmock.spring.spy.private1.void1;

import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

public class TestSpSPrVDoNothing extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        PowerMockito.doNothing().when(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, Mockito.any
                (StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, stringBuffer);

        Assert.assertEquals(0, stringBuffer.toString().length());
    }
}
