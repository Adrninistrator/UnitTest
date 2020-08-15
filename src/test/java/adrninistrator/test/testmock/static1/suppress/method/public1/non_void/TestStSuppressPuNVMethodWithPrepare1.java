package adrninistrator.test.testmock.static1.suppress.method.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 使用@PrepareForTest注解指定被Suppress方法所在类，Suppress生效
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStSuppressPuNVMethodWithPrepare1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));

        String str = TestStaticPublicNonVoid1.test1("", null);

        assertNull(str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }
}
