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

/*
    在TestPolicyOrderStubA中执行了settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader
    (TestStaticPublicNonVoid1.class.getName());
    在当前类中不需要通过@PrepareForTest指定TestStaticPublicNonVoid1.class
 */
@MockPolicy(TestPolicyOrderStubA.class)
public class TestStMockPolicyStub1 extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST4))
                .toReturn(TestConstants.FLAG2);
    }

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.FLAG1, str);

        str = TestStaticPublicNonVoid1.test4("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
