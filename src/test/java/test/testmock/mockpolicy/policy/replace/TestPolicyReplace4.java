package test.testmock.mockpolicy.policy.replace;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestPolicyReplace4 implements PowerMockPolicy {

    @Override
    public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
        settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(
                new String[]{TestStaticPublicNonVoid1.class.getName(), TestPublicNonVoidService1Impl.class.getName()});
    }

    @Override
    public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {

        Map<Method, InvocationHandler> map = new HashMap<>(2);
        map.put(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1),
                (proxy, method, args) -> TestConstants.MOCKED);
        map.put(PowerMockito.method(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1),
                (proxy, method, args) -> TestConstants.MOCKED);

        settings.setMethodsToProxy(map);
    }
}
