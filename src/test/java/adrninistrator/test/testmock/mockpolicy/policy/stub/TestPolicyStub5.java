package adrninistrator.test.testmock.mockpolicy.policy.stub;

import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestPolicyStub5 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(
                TestPublicNonVoidService1Impl.class.getName(),
                TestPublicNonVoidService1Impl.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
    }
}
