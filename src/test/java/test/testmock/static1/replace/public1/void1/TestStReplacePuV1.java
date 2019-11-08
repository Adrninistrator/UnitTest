package test.testmock.static1.replace.public1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//Replace生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStReplacePuV1 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                ((proxy, method, args) -> {

                    StringBuffer arg1 = (StringBuffer) args[0];

                    arg1.append(TestConstants.MOCKED);

                    return null;
                }));

        StringBuffer stringBuffer = new StringBuffer();

        TestStaticPublicVoid1.test1(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
