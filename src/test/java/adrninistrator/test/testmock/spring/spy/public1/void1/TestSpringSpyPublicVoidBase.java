package adrninistrator.test.testmock.spring.spy.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicVoidService1;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TestSpringSpyPublicVoidBase extends TestMockBase {

    @Autowired
    protected TestPublicVoidService1 testPublicVoidService1;

    protected TestPublicVoidService1 testPublicVoidService1Spy;

    @Before
    public void initTestSpringSpyPublicVoidBase() {
        testPublicVoidService1Spy = Mockito.spy(testPublicVoidService1);
    }
}
