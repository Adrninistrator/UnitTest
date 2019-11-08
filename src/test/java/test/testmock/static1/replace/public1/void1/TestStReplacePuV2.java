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
public class TestStReplacePuV2 extends TestMockNoSpBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                (PowerMockito.method(TestStReplacePuV2.class, "replace_test1")));

        StringBuffer stringBuffer = new StringBuffer();

        TestStaticPublicVoid1.test1(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }

    public static void replace_test1(StringBuffer stringBuffer) {

        stringBuffer.append(TestConstants.MOCKED);
    }
}
