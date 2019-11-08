package test.testmock.static1.replace.private1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//Replace生效
@PrepareForTest({TestStaticPrivateVoid1.class})
public class TestStReplacePrV2 extends TestMockNoSpBase {

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1))
                .with(PowerMockito.method(TestStReplacePrV2.class, "replace_test1"));

        StringBuffer stringBuffer = new StringBuffer();

        TestStaticPrivateVoid1.testPublic1(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }

    private static void replace_test1(StringBuffer stringBuffer) {

        stringBuffer.append(TestConstants.MOCKED);
    }
}
