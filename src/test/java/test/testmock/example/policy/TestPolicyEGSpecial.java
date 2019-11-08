package test.testmock.example.policy;

import com.test.service.impl.example.TestServiceEG2Impl;
import com.test.service.impl.example.TestServiceEG3Impl;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestPolicyEGSpecial implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {

        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(new String[]{
                TestServiceEG2Impl.class.getName(), TestServiceEG3Impl.class.getName()});
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
    }
}