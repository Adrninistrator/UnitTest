package adrninistrator.test.testmock.static1.suppress.field;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 使用@PrepareForTest注解指定被Suppress属性所在类时，Suppress生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressFieldWithPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        String str = TestStaticPublicNonVoid1.getFlag();

        assertNull(str);

        str = TestStaticPublicNonVoid1.getFlag2();

        assertEquals(TestConstants.MINUS + "null", str);
    }
}
