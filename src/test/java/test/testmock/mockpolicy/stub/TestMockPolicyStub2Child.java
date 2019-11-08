package test.testmock.mockpolicy.stub;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;

//父类中的@MockPolicy注解生效
public class TestMockPolicyStub2Child extends TestMockPolicyStub2 {

    @Test
    public void testChild1() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void testChild2() {

        String str = testPublicNonVoidService1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
