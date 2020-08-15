package adrninistrator.test.testmock.mockpolicy.mix.static1.nomock;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubA;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

/*
    在TestPolicyOrderStubA中执行了settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader
    (TestStaticPublicNonVoid1.class.getName());
    在当前类中不需要通过@PrepareForTest指定TestStaticPublicNonVoid1.class
 */
@MockPolicy(TestPolicyOrderStubA.class)
public class TestStMockPolicyStub1 extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)).toReturn(TestConstants.FLAG2);
    }

    @Test
    public void test() {
        // @Before方法中的Stub生效
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.FLAG2, str);
    }
}
