package adrninistrator.test.testmock.mockpolicy.mix.static1.mock;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceC;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

@MockPolicy({TestPolicyOrderReplaceC.class})
public class TestStMockPolicyReMock2CallReal extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class, new CallsRealMethods());
    }

    @Test
    public void test() {
        Mockito.when(TestStaticPublicNonVoid1.test4(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        // Mockito.when().thenReturn()生效
        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, str);

        // Mockito.when().thenReturn()，参数不满足Stub条件，settings.proxyMethod生效
        str = TestStaticPublicNonVoid1.test4("");
        assertEquals(TestConstants.FLAG1, str);
    }
}
