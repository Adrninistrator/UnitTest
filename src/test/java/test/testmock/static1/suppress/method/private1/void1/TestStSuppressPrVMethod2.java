package test.testmock.static1.suppress.method.private1.void1;

import com.test.service.TestPrivateVoidService1;
import com.test.static1.TestStaticPrivateVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Suppress生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStSuppressPrVMethod2 extends TestMockBase {

    @Autowired
    private TestPrivateVoidService1 testPrivateVoidService1;

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1));

        StringBuffer stringBuffer = new StringBuffer();

        testPrivateVoidService1.testStatic1(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());
    }
}
