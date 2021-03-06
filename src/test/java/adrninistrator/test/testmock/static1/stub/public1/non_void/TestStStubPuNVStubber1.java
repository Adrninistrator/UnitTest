package adrninistrator.test.testmock.static1.stub.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.Stubber;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Stubber.stubMethod也支持Stub，传入参数为Method
// 需要使用@PrepareForTest
@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStStubPuNVStubber1 extends TestStStubPuNVBase {

    @Test
    public void test() {
        Stubber.stubMethod(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1),
                TestConstants.MOCKED);

        String str = TestStaticPublicNonVoid1.test1("", null);

        // Stubber.stubMethod也支持Stub，传入参数为Method
        assertEquals(TestConstants.MOCKED, str);
    }
}
