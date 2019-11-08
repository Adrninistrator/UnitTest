package test.testmock.mockpolicy.policy.spring;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestSpPolicyStubA implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestServiceA1Impl.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        settings.stubMethod(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1),
                TestConstants.FLAG1);
    }
}