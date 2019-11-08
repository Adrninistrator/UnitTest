package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVIndirect1 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.MOCKED);

        String str = testPublicNonVoidService1.testStatic1("", null);

        //间接调用，replace生效
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
