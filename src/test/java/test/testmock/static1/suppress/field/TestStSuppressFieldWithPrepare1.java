package test.testmock.static1.suppress.field;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//使用@PrepareForTest注解指定被Suppress属性所在类时，Suppress生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressFieldWithPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        String str = TestStaticPublicNonVoid1.getFlag();

        Assert.assertNull(str);

        str = TestStaticPublicNonVoid1.getFlag2();

        Assert.assertEquals(TestConstants.MINUS + "null", str);
    }
}
