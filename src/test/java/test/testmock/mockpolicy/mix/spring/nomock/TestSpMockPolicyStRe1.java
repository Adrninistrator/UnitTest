package test.testmock.mockpolicy.mix.spring.nomock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import test.testmock.mockpolicy.policy.spring.TestSpPolicyStubA;

@MockPolicy(TestSpPolicyStubA.class)
public class TestSpMockPolicyStRe1 extends TestSpMockPolicyBase {

    @Before
    public void init() {
        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)
        ).with((proxy, method, args) -> TestConstants.FLAG2);
    }

    @Test
    public void test() {

        String str = testServiceA1.test1("");
        Assert.assertEquals(TestConstants.FLAG1, str);
    }
}
