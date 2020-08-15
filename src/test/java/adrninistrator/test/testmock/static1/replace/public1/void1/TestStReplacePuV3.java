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
public class TestStReplacePuV3 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                ((proxy, method, args) -> {

                    StringBuilder arg1 = (StringBuilder) args[0];

                    arg1.append(TestConstants.MOCKED);

                    return null;
                }));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.testStatic1(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }
}
