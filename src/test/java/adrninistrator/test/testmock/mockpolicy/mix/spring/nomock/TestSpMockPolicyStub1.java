package adrninistrator.test.testmock.mockpolicy.mix.spring.nomock;

import adrninistrator.test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import adrninistrator.test.testmock.mockpolicy.policy.spring.TestSpPolicyStubA;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

@MockPolicy(TestSpPolicyStubA.class)
public class TestSpMockPolicyStub1 extends TestSpMockPolicyBase {

    @Before
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toReturn(TestConstants.FLAG2);
    }

    @Test
    public void test() {
        // @Before方法中的Stub生效
        String str = testServiceA1.test1("");
        assertEquals(TestConstants.FLAG2, str);
    }
}
