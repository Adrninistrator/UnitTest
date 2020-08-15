package adrninistrator.test.testmock.spring.spy.private1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPrivateNonVoidService1;
import com.adrninistrator.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

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
