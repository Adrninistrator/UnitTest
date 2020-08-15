package adrninistrator.test.testmock.mockpolicy.mix.spring.base;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestServiceA1;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TestSpMockPolicyBase extends TestMockBase {

    @Autowired
    protected TestServiceA1 testServiceA1;

    protected TestServiceA1 testServiceA1Mock;

    protected TestServiceA1 testServiceA1Spy;

    @Before
    public void initTestSpMockPolicyBase() {
        testServiceA1Mock = Mockito.mock(TestServiceA1.class);

        testServiceA1Spy = Mockito.spy(testServiceA1);
    }
}
