package adrninistrator.test.testmock.custom_init_method.init_method;

import adrninistrator.test.common.TestInitInterface;
import com.adrninistrator.service.impl.TestServiceB1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.powermock.api.mockito.PowerMockito;

public class TestInitSuppress implements TestInitInterface {

    @Override
    public void init() {
        PowerMockito.suppress(PowerMockito.field(TestStaticPublicNonVoid1.class, "flag"));
        PowerMockito.suppress(PowerMockito.field(TestServiceB1Impl.class, "testServiceA1"));

        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));
        PowerMockito.suppress(PowerMockito.method(TestServiceB1Impl.class, TestServiceB1Impl.NAME_TEST1));
    }
}
