package adrninistrator.test.testmock.custom_init_method.init_method;

import adrninistrator.test.common.TestInitInterface;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;

public class TestInitStub1 implements TestInitInterface {

    @Override
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)).toReturn(TestConstants.MOCKED);
    }
}
