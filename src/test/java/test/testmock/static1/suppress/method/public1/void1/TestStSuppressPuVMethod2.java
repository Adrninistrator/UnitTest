package test.testmock.static1.suppress.method.public1.void1;

import com.test.service.TestPublicVoidService1;
import com.test.static1.TestStaticPublicVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Suppress生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStSuppressPuVMethod2 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.testStatic1(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());
    }
}
