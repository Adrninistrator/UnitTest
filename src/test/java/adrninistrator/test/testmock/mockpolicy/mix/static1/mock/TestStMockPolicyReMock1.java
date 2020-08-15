package adrninistrator.test.testmock.mockpolicy.mix.static1.mock;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceA;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderReplaceC;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@MockPolicy({TestPolicyOrderReplaceA.class, TestPolicyOrderReplaceC.class})
public class TestStMockPolicyReMock1 extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.FLAG2);

        // Mockito.when().thenReturn()生效
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.FLAG2, str);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test4(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        // Mockito.when().thenReturn()生效
        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, str);

        // Mockito.when().thenReturn()，参数不满足Stub条件，返回null
        str = TestStaticPublicNonVoid1.test4("");
        assertNull(str);
    }
}
