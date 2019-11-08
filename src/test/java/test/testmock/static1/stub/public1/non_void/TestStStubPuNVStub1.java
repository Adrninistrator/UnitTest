package test.testmock.static1.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;

public class TestStStubPuNVStub1 {

    public static void stub() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);
    }

    private TestStStubPuNVStub1() {
        throw new IllegalStateException("illegal");
    }
}
