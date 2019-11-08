package test.testmock.mockpolicy.policy.order;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

public class TestPolicyOrderReplaceB implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestStaticPublicNonVoid1.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        settings.proxyMethod(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)
                , (proxy, method, args) -> TestConstants.FLAG2);
    }
}