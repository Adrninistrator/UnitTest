package adrninistrator.test.testmock.static1.replace.public1.non_void;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.*;

// 将真实方法替换为目标方法
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVMethod1 extends TestMockNoSpBase {

    private static boolean called = false;

    @Test
    public void test1() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePuNVMethod1.class, "replace_test1"));

        assertFalse(called);

        String str = TestStaticPublicNonVoid1.test1("", null);

        assertEquals(TestConstants.MOCKED, str);

        assertTrue(called);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1));
    }

    @Test
    public void test2() {
        // PowerMockito.replace().with()方法，要求被替换的方法，及替换后的方法均为静态方法，因此会出现异常
        assertThrows(Exception.class, () ->
                PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                        .with(PowerMockito.method(TestStReplacePuNVMethod1.class, "replace_test2"))
        );
    }

    public static String replace_test1(String str, TestTableEntity testTableEntity) {
        called = true;

        return TestConstants.MOCKED;
    }

    public String replace_test2(String str, TestTableEntity testTableEntity) {
        return null;
    }
}
