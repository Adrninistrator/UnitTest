package adrninistrator.test.testmock.static1.replace.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPrivateVoidService1;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Replace间接调用生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStReplacePrV4 extends TestMockBase {

    @Autowired
    private TestPrivateVoidService1 testPrivateVoidService1;

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePrV4.class, "replace_test1"));

        StringBuilder stringBuilder = new StringBuilder();

        testPrivateVoidService1.testStatic1(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }

    private static void replace_test1(StringBuilder stringBuilder) {
        stringBuilder.append(TestConstants.MOCKED);
    }
}
