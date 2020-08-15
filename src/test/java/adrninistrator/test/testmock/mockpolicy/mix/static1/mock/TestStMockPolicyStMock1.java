package adrninistrator.test.testmock.mockpolicy.mix.static1.mock;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubA;
import adrninistrator.test.testmock.mockpolicy.policy.order.TestPolicyOrderStubC;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertThrows;

@MockPolicy({TestPolicyOrderStubA.class, TestPolicyOrderStubC.class})
public class TestStMockPolicyStMock1 extends TestMockNoSpBase {

    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test() {
        // settings.stubMethod后执行Mockito.when会出现异常
        assertThrows(Exception.class, () ->
                Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                        .thenReturn(TestConstants.FLAG2)
        );
    }
}
