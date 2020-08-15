package adrninistrator.test.testmock.static1.suppress.field;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// 不使用@PrepareForTest注解指定被Suppress属性所在类，Suppress不生效
public class TestStSuppressFieldNoPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_GETFLAG));

        String str = TestStaticPublicNonVoid1.getFlag();

        assertNotNull(str);
        assertEquals("flag", str);
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_GETFLAG));

        str = TestStaticPublicNonVoid1.getFlag2();

        assertEquals(TestConstants.MINUS + "flag", str);

        str = Whitebox.getInternalState(TestStaticPublicNonVoid1.class, "flag");
        assertNotNull(str);
        assertEquals("flag", str);
    }
}
