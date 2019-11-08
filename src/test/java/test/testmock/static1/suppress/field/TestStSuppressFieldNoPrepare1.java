package test.testmock.static1.suppress.field;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockNoSpBase;

//不使用@PrepareForTest注解指定被Suppress属性所在类，Suppress不生效
public class TestStSuppressFieldNoPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_GETFLAG));

        String str = TestStaticPublicNonVoid1.getFlag();

        Assert.assertNotNull(str);
        Assert.assertEquals("flag", str);
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_GETFLAG));

        str = TestStaticPublicNonVoid1.getFlag2();

        Assert.assertEquals(TestConstants.MINUS + "flag", str);

        str = Whitebox.getInternalState(TestStaticPublicNonVoid1.class, "flag");
        Assert.assertNotNull(str);
        Assert.assertEquals("flag", str);
    }
}
