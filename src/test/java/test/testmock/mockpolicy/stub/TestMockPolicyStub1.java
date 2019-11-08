package test.testmock.mockpolicy.stub;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub1;

/*
    TestPolicyStub1类的applyClassLoadingPolicy方法中
    未通过settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader指定TestStaticPublicNonVoid1
    stub未生效
 */
@MockPolicy(TestPolicyStub1.class)
public class TestMockPolicyStub1 extends TestMockNoSpBase {

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
