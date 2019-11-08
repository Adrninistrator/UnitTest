package test.testmock.mockpolicy.replace;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.replace.TestPolicyReplace2;

@MockPolicy(TestPolicyReplace2.class)
public class TestMockPolicyReplace2 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        TestStaticPublicNonVoid1.test1("", null);
    }

    @Test
    public void test2() {

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicNonVoidService1.test1("");
    }
}
