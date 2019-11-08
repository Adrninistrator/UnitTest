package test.testmock.spring.spy.private1.void1;

import com.test.service.TestPrivateVoidService1;
import com.test.service.impl.TestPrivateVoidService1Impl;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

@PrepareForTest({TestPrivateVoidService1Impl.class})
public abstract class TestSpringSpyPrivateVoidBase extends TestMockBase {

    @Autowired
    protected TestPrivateVoidService1 testPrivateVoidService1;

    protected TestPrivateVoidService1 testPrivateVoidService1Spy;

    @Before
    public void initTestSpringSpyPrivateVoidBase() {
        testPrivateVoidService1Spy = PowerMockito.spy(testPrivateVoidService1);
    }
}
