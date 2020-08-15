package adrninistrator.test.testmock.static1.suppress.method.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Suppress生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStSuppressPuVMethod2 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.testStatic1(stringBuilder);

        assertEquals(0, stringBuilder.length());
    }
}
