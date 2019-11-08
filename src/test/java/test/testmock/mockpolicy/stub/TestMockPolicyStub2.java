package test.testmock.mockpolicy.stub;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub2;

/*
    TestPolicyStub2类的applyClassLoadingPolicy方法中
    通过settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader指定TestStaticPublicNonVoid1
    Stub生效
 */
@MockPolicy(TestPolicyStub2.class)
public class TestMockPolicyStub2 extends TestMockBase {

    @Autowired
    protected TestPublicNonVoidService1 testPublicNonVoidService1;

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
