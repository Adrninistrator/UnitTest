package test.testmock.static1.replace.private1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.base.TestMockNoSpBase;

//Replace生效
@PrepareForTest({TestStaticPrivateNonVoid1.class})
public class TestStReplacePrNV1 extends TestMockNoSpBase {

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.MOCKED);

        String str = TestStaticPrivateNonVoid1.testPublic1("", null);

        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
