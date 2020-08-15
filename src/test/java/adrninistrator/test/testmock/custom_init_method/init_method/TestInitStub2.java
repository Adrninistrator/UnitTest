package adrninistrator.test.testmock.custom_init_method.init_method;

import adrninistrator.test.common.TestInitInterface;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import org.powermock.api.mockito.PowerMockito;

public class TestInitStub2 implements TestInitInterface {

    @Override
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1)).toReturn(TestConstants.MOCKED);
    }
}
