package test.testmock.mockpolicy.policy.stub;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestPolicyStub1 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {

    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        settings.stubMethod(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1),
                TestConstants.MOCKED);
    }
}
