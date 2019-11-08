package test.testmock.static1.suppress.method.public1.non_void;

import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.SuppressCode;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//使用SuppressCode.suppressMethod()方法对方法进行Suppress
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressPuNVMethodSuppressCode1 extends TestMockNoSpBase {

    @Test
    public void test() {

        SuppressCode.suppressMethod(PowerMockito.method(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));

        String str = TestStaticPublicNonVoid1.test1("", null);

        Assert.assertNull(str);
    }
}
