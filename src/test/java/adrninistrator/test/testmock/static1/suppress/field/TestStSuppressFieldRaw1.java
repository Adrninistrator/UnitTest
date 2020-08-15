package adrninistrator.test.testmock.static1.suppress.field;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// 通过反射获取被Suppress的属性的实际值，值未被改变
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressFieldRaw1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        String str = Whitebox.getInternalState(TestStaticPublicNonVoid1.class, "flag");
        assertNotNull(str);
        assertEquals("flag", str);
    }
}
