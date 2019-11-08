package test.testmock.spring.spy.public1.non_void;

import com.test.service.TestPublicNonVoidService1;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public abstract class TestSpringSpyPublicNonVoidBase extends TestMockBase {

    @Autowired
    protected TestPublicNonVoidService1 testPublicNonVoidService1;

    protected TestPublicNonVoidService1 testPublicNonVoidService1Spy;

    @Before
    public void initTestSpringSpyPublicNonVoidBase() {
        testPublicNonVoidService1Spy = Mockito.spy(testPublicNonVoidService1);
    }
}
