package test.testmock.static1.suppress.method.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.base.TestMockNoSpBase;

//不使用@PrepareForTest注解指定被Suppress方法所在类，Suppress不生效
public class TestStSuppressPuNVMethodNoPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));

        String str = TestStaticPublicNonVoid1.test1("", null);

        //由于没有通过@PrepareForTest指定TestStaticPublicNonVoid1.class，因此PowerMockito.suppress不生效
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
