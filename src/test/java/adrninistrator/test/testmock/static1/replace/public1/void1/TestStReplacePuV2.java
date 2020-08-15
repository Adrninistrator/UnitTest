package adrninistrator.test.testmock.static1.replace.public1.void1;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Replace生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStReplacePuV2 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                (PowerMockito.method(TestStReplacePuV2.class, "replace_test1")));

        StringBuilder stringBuilder = new StringBuilder();

        TestStaticPublicVoid1.test1(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }

    public static void replace_test1(StringBuilder stringBuilder) {
        stringBuilder.append(TestConstants.MOCKED);
    }
}
