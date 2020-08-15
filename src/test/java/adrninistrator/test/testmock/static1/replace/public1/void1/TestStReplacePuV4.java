package adrninistrator.test.testmock.static1.replace.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Replace间接调用生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStReplacePuV4 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                (PowerMockito.method(TestStReplacePuV4.class, "replace_test1")));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.testStatic1(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }

    public static void replace_test1(StringBuilder stringBuilder) {
        stringBuilder.append(TestConstants.MOCKED);
    }
}
