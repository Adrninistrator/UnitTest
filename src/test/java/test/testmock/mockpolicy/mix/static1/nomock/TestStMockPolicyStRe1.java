package test.testmock.mockpolicy.mix.static1.nomock;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.mockpolicy.policy.order.TestPolicyOrderStubA;

@MockPolicy(TestPolicyOrderStubA.class)
public class TestStMockPolicyStRe1 extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)
        ).with((proxy, method, args) -> TestConstants.FLAG2);
    }

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.FLAG1, str);
    }
}
