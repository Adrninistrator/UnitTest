package test.testmock.mockpolicy.mix.static1.mock;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceC;

@MockPolicy({TestPolicyOrderReplaceC.class})
public class TestStMockPolicyReMock2CallReal extends TestMockNoSpBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class, new CallsRealMethods());
    }

    @Test
    public void test() {

        Mockito.when(TestStaticPublicNonVoid1.test4(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        //Mockito.when().thenReturn()生效
        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG2);
        Assert.assertEquals(TestConstants.FLAG2, str);

        ////Mockito.when().thenReturn()，参数不满足Stub条件，settings.proxyMethod生效
        str = TestStaticPublicNonVoid1.test4("");
        Assert.assertEquals(TestConstants.FLAG1, str);
    }
}
