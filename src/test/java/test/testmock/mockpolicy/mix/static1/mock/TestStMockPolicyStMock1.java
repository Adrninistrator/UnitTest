package test.testmock.mockpolicy.mix.static1.mock;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.mockpolicy.policy.order.TestPolicyOrderStubA;
import test.testmock.mockpolicy.policy.order.TestPolicyOrderStubC;

@MockPolicy({TestPolicyOrderStubA.class, TestPolicyOrderStubC.class})
public class TestStMockPolicyStMock1 extends TestMockNoSpBase {

    @Before
    public void init() {

        PowerMockito.mockStatic(TestStaticPublicNonVoid1.class);
    }

    @Test
    public void test() {

        //settings.stubMethod后执行Mockito.when会出现异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenReturn(TestConstants.FLAG2);
    }
}
