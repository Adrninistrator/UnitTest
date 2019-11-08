package test.testmock.spring.spy.public1.void1;

import com.test.service.TestPublicVoidService1;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public abstract class TestSpringSpyPublicVoidBase extends TestMockBase {

    @Autowired
    protected TestPublicVoidService1 testPublicVoidService1;

    protected TestPublicVoidService1 testPublicVoidService1Spy;

    @Before
    public void initTestSpringSpyPublicVoidBase() {
        testPublicVoidService1Spy = Mockito.spy(testPublicVoidService1);
    }
}
