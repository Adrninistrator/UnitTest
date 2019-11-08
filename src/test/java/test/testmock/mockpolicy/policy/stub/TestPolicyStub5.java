package test.testmock.mockpolicy.policy.stub;

import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestPolicyStub5 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(
                new String[]{TestStaticPublicNonVoid1.class.getName(), TestPublicNonVoidService1Impl.class.getName()});
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
    }
}
