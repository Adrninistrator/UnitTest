package adrninistrator.test.testmock.static1.suppress.method.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPrivateVoidService1;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Suppress生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStSuppressPrVMethod2 extends TestMockBase {

    @Autowired
    private TestPrivateVoidService1 testPrivateVoidService1;

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1));

        StringBuilder stringBuilder = new StringBuilder();

        testPrivateVoidService1.testStatic1(stringBuilder);

        assertEquals(0, stringBuilder.length());
    }
}
