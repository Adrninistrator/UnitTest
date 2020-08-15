package adrninistrator.test.testmock.custom_init_method.init_method;

import adrninistrator.test.common.TestInitInterface;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;

public class TestInitReplace implements TestInitInterface {

    @Override
    public void init() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)).with(
                (proxy, method, args) -> TestConstants.MOCKED);

        PowerMockito.replace(PowerMockito.method(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1)).with(
                (proxy, method, args) -> TestConstants.MOCKED);
    }
}
