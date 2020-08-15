package adrninistrator.test.testmock.static1.replace.private1.void1;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Replace生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStReplacePrV1 extends TestMockNoSpBase {

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1))
                .with((proxy, method, args) -> {

                    StringBuilder arg1 = (StringBuilder) args[0];

                    arg1.append(TestConstants.MOCKED);

                    return null;
                });

        StringBuilder stringBuilder = new StringBuilder();

        TestStaticPrivateVoid1.testPublic1(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }
}
