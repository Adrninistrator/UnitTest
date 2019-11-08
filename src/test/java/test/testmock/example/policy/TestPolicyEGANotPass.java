package test.testmock.example.policy;

import com.test.service.impl.example.TestServiceEG1Impl;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;
import test.testmock.example.base.TestEGCommon;

public class TestPolicyEGANotPass implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestServiceEG1Impl.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        settings.stubMethod(PowerMockito.method(TestServiceEG1Impl.class, TestEGCommon.NAME_CHECKA), false);
    }
}