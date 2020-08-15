package adrninistrator.test.testmock.static1.suppress.method.private1.void1;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Suppress生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStSuppressPrVMethod1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1));

        StringBuilder stringBuilder = new StringBuilder();

        TestStaticPrivateVoid1.testPublic1(stringBuilder);

        assertEquals(0, stringBuilder.length());
    }
}
