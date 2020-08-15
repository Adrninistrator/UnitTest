package adrninistrator.test.testmock.mockpolicy.order;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceA;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubB;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

/*
    在@MockPolicy注解指定执行Replace操作与执行Stub操作的PowerMockPolicy实现类
    执行Stub操作的PowerMockPolicy实现类的操作生效
 */
@MockPolicy({TestPolicyOrderReplaceA.class, TestPolicyOrderStubB.class})
public class TestMockPolicyOrderRS1 extends TestMockNoSpBase {

    @Test
    public void test() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.FLAG2, str);
    }
}
