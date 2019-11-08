package test.testmock.static1.suppress.method.public1.non_void;

import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//间接调用被Suppress方法，Suppress也生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressPuNVMethodIndirect1 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));

        String str = testPublicNonVoidService1.testStatic1("", null);

        Assert.assertNull(str);
    }
}
