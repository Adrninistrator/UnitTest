package adrninistrator.test.testmock.static1.suppress.method.public1.void1;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Suppress生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStSuppressPuVMethod1 extends TestMockNoSpBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1));

        StringBuilder stringBuilder = new StringBuilder();

        TestStaticPublicVoid1.test1(stringBuilder);

        assertEquals(0, stringBuilder.length());
    }
}
