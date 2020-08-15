package adrninistrator.test.testmock.mockpolicy.order;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubA;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubB;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

/*
    在@MockPolicy注解指定多个执行Stub操作的PowerMockPolicy实现类
    最后指定的PowerMockPolicy实现类的操作生效
 */
@MockPolicy({TestPolicyOrderStubA.class, TestPolicyOrderStubB.class})
public class TestMockPolicyOrderStub1 extends TestMockNoSpBase {

    @Test
    public void test() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.FLAG2, str);
    }
}
