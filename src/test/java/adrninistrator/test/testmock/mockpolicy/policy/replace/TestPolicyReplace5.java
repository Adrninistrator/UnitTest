package adrninistrator.test.testmock.mockpolicy.policy.replace;

import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestPolicyReplace5 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(
                new String[]{TestStaticPublicNonVoid1.class.getName(), TestPublicNonVoidService1Impl.class.getName()});
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
    }
}
