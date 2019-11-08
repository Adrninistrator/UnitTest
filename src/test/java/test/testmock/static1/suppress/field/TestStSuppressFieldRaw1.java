package test.testmock.static1.suppress.field;

import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockNoSpBase;

//通过反射获取被Suppress的属性的实际值，值未被改变
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressFieldRaw1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        String str = Whitebox.getInternalState(TestStaticPublicNonVoid1.class, "flag");
        Assert.assertNotNull(str);
        Assert.assertEquals("flag", str);
    }
}
