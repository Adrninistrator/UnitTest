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
public class TestStReplacePuV3 extends TestMockBase {

    @Autowired
    private TestPublicVoidService1 testPublicVoidService1;

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1)).with(
                ((proxy, method, args) -> {

                    StringBuffer arg1 = (StringBuffer) args[0];

                    arg1.append(TestConstants.MOCKED);

                    return null;
                }));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.testStatic1(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
