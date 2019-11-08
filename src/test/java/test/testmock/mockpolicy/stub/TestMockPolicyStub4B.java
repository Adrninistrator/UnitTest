package test.testmock.mockpolicy.stub;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub4Multi1;

@MockPolicy({TestPolicyStub4Multi1.class})
public class TestMockPolicyStub4B extends TestMockNoSpBase {

    @BeforeClass
    public static void beforeClass() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Before
    public void init() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
