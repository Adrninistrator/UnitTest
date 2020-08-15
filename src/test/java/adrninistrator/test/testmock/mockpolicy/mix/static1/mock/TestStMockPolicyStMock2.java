package adrninistrator.test.testmock.mockpolicy.mix.static1.mock;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubA;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

@MockPolicy({TestPolicyOrderStubA.class})
public class TestStMockPolicyStMock2 extends TestMockNoSpBase {

    @BeforeClass
    public static void beforeClass() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.FLAG2);
    }

    @Test
    public void test() {
        // settings.stubMethod生效
        String str = TestStaticPublicNonVoid1.test1("", new TestTableEntity());
        assertEquals(TestConstants.FLAG1, str);
    }
}
