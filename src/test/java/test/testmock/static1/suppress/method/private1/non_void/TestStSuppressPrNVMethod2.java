package test.testmock.static1.suppress.method.private1.non_void;

import com.test.service.TestPrivateNonVoidService1;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Suppress生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStSuppressPrNVMethod2 extends TestMockBase {

    @Autowired
    private TestPrivateNonVoidService1 testPrivateNonVoidService1;

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));

        String str = testPrivateNonVoidService1.testStatic1("", null);

        Assert.assertNull(str);
    }
}
