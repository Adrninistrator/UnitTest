package adrninistrator.test.testmock.mockpolicy.mix.static1.nomock;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceA;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertNull;

@MockPolicy(TestPolicyOrderReplaceA.class)
public class TestStMockPolicyReSu1 extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.suppress(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1));
    }

    @Test
    public void test() {
        // Suppress生效
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertNull(str);
    }
}
