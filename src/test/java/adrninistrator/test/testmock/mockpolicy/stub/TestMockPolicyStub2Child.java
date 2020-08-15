package adrninistrator.test.testmock.mockpolicy.stub;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 父类中的@MockPolicy注解生效
public class TestMockPolicyStub2Child extends TestMockPolicyStub2 {

    @Test
    public void testChild1() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void testChild2() {
        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
