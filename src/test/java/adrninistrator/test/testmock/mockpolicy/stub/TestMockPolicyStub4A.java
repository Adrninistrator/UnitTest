package adrninistrator.test.testmock.mockpolicy.stub;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub4Multi1;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub4Multi2;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// @MockPolicy注解支持指定多个PowerMockPolicy实现类
@MockPolicy({TestPolicyStub4Multi1.class, TestPolicyStub4Multi2.class})
public class TestMockPolicyStub4A extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
