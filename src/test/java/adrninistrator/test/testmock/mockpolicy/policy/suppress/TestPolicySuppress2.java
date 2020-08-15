package adrninistrator.test.testmock.mockpolicy.policy.suppress;

import com.adrninistrator.service.impl.TestServiceB1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

import java.lang.reflect.Field;

public class TestPolicySuppress2 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestStaticPublicNonVoid1.class.getName());

        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(TestServiceB1Impl.class.getName());
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
        settings.addFieldToSuppress(new Field[]{
                PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"),
                PowerMockito.field(TestServiceB1Impl.class, "testServiceA1")});
    }
}
