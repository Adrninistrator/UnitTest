package test.testmock.mockpolicy.mix.spring.nomock;

import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import test.testmock.mockpolicy.policy.spring.TestSpPolicyReplaceA;

@MockPolicy(TestSpPolicyReplaceA.class)
public class TestSpMockPolicyReSu1 extends TestSpMockPolicyBase {

    @Before
    public void init() {
        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));
    }

    @Test
    public void test() {

        String str = testServiceA1.test1("");
        Assert.assertNull(str);
    }
}
