package test.testmock.spring.spy.private1.non_void;

import com.test.service.TestPrivateNonVoidService1;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

@PrepareForTest({TestPrivateNonVoidService1Impl.class})
public abstract class TestSpringSpyPrivateNonVoidBase extends TestMockBase {

    @Autowired
    protected TestPrivateNonVoidService1 testPrivateNonVoidService1;

    protected TestPrivateNonVoidService1 testPrivateNonVoidService1Spy;

    @Before
    public void initTestSpringSpyPrivateNonVoidBase() {
        testPrivateNonVoidService1Spy = PowerMockito.spy(testPrivateNonVoidService1);
    }
}
