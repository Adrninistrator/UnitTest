package test.testmock.mockpolicy.policy.spring;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestSpPolicyReplaceA implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestServiceA1Impl.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        settings.proxyMethod(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)
                , (proxy, method, args) -> TestConstants.FLAG1);
    }
}