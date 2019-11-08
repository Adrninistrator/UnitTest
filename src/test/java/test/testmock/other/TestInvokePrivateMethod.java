package test.testmock.other;

import com.test.common.TestConstants;
import com.test.service.TestPrivateNonVoidService1;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public class TestInvokePrivateMethod extends TestMockBase {

    @Autowired
    private TestPrivateNonVoidService1 testPrivateNonVoidService1;

    @Test
    public void test() throws Exception {

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        str = (String) PowerMockito.method(TestPrivateNonVoidService1Impl.class, TestPrivateNonVoidService1Impl
                .NAME_TEST1).invoke(testPrivateNonVoidService1, "");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
