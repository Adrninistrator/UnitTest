package test.testmock.static1.suppress.field;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.SuppressCode;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockNoSpBase;

//使用SuppressCode.suppressField()方法对属性进行Suppress
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressFieldSuppressCode1 extends TestMockNoSpBase {

    @Test
    public void test() {

        SuppressCode.suppressField(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        String str = TestStaticPublicNonVoid1.getFlag();

        Assert.assertNull(str);

        str = TestStaticPublicNonVoid1.getFlag2();

        Assert.assertEquals(TestConstants.MINUS + "null", str);

        str = Whitebox.getInternalState(TestStaticPublicNonVoid1.class, "flag");
        Assert.assertNotNull(str);
        Assert.assertEquals("flag", str);
    }
}
