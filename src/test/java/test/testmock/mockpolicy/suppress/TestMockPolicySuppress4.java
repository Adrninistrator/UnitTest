package test.testmock.mockpolicy.suppress;

import com.test.service.TestServiceB1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.suppress.TestPolicySuppress4;

@MockPolicy(TestPolicySuppress4.class)
public class TestMockPolicySuppress4 extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertNull(str);
    }

    @Test
    public void test2() {

        String str = testServiceB1.test1("");
        Assert.assertNull(str);
    }
}
