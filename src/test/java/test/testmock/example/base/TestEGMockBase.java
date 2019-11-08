package test.testmock.example.base;

import com.test.common.TestConstants;
import com.test.service.example.TestServiceEG2;
import com.test.service.example.TestServiceEG3;
import com.test.service.example.TestServiceEG4;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.example.policy.TestPolicyEGAPass;

@MockPolicy({TestPolicyEGAPass.class})
public abstract class TestEGMockBase extends TestMockBase {

    @Autowired
    protected TestServiceEG4 testServiceEG4;

    @Before
    public void initTestEGMockBase() {

        TestServiceEG2 testServiceEG2Mock = Mockito.mock(TestServiceEG2.class);

        Mockito.when(testServiceEG2Mock.checkB(Mockito.anyString())).thenReturn(chooseCheckB());

        Whitebox.setInternalState(testServiceEG4, testServiceEG2Mock);

        TestServiceEG3 testServiceEG3 = Whitebox.getInternalState(testServiceEG4, TestServiceEG3.class);

        TestServiceEG3 testServiceEG3Spy = Mockito.spy(testServiceEG3);

        Mockito.doReturn(chooseCheckC()).when(testServiceEG3Spy).checkC(Mockito.anyString());

        Whitebox.setInternalState(testServiceEG4, testServiceEG3Spy);
    }

    protected String chooseCheckB() {
        return TestConstants.FLAG1;
    }

    protected abstract String chooseCheckC();
}
