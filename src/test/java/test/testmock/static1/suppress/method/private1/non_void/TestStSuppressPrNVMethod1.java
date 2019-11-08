package test.testmock.static1.suppress.method.private1.non_void;

import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//Suppress生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStSuppressPrNVMethod1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));

        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        Assert.assertNull(str);
    }
}
