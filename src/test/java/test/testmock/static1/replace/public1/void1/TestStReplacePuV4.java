package test.testmock.static1.replace.public1.void1;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.static1.TestStaticPublicVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Replace间接调用生效
@PrepareForTest({TestStaticPublicVoid1.class})
public class TestStReplacePuV4 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                (PowerMockito.method(TestStReplacePuV4.class, "replace_test1")));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.testStatic1(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }

    public static void replace_test1(StringBuffer stringBuffer) {

        stringBuffer.append(TestConstants.MOCKED);
    }
}
