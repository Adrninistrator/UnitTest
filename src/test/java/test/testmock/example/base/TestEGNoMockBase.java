package test.testmock.example.base;

import com.test.common.TestConstants;
import com.test.service.example.TestServiceEG4;
import com.test.service.impl.example.TestServiceEG2Impl;
import com.test.service.impl.example.TestServiceEG3Impl;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.example.policy.TestPolicyEGAPass;
import test.testmock.example.policy.TestPolicyEGSpecial;

@MockPolicy({TestPolicyEGAPass.class, TestPolicyEGSpecial.class})
public abstract class TestEGNoMockBase extends TestMockBase {

    @Autowired
    protected TestServiceEG4 testServiceEG4;

    @Before
    public void initTestEGMockBase() {

        PowerMockito.stub(PowerMockito.method(TestServiceEG2Impl.class, TestEGCommon.NAME_CHECKB)).toReturn
                (chooseCheckB());

        PowerMockito.replace(PowerMockito.method(TestServiceEG3Impl.class, TestEGCommon.NAME_CHECKC)).with(
                (proxy, method, args) -> chooseCheckC());
    }

    protected String chooseCheckB() {
        return TestConstants.FLAG1;
    }

    protected abstract String chooseCheckC();
}
