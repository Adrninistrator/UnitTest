package test.testmock.mockpolicy.policy.suppress;

import com.test.service.impl.TestServiceB1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

import java.lang.reflect.Method;

public class TestPolicySuppress4 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestStaticPublicNonVoid1.class.getName());

        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestServiceB1Impl.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        settings.setMethodsToSuppress(new Method[]{PowerMockito.method(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST1), PowerMockito.method(TestServiceB1Impl.class, TestServiceB1Impl
                .NAME_TEST1)});
    }
}
