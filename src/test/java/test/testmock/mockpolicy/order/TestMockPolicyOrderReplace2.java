package test.testmock.mockpolicy.order;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceA;
import test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceB;

@MockPolicy({TestPolicyOrderReplaceB.class, TestPolicyOrderReplaceA.class})
public class TestMockPolicyOrderReplace2 extends TestMockNoSpBase {

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.FLAG1, str);
    }
}