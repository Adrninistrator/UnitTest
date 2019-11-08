package test.testmock.mockpolicy.stub;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub4Multi1;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub4Multi2;

@MockPolicy({TestPolicyStub4Multi1.class, TestPolicyStub4Multi2.class})
public class TestMockPolicyStub4A extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {

        String str = testPublicNonVoidService1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
