package adrninistrator.test.testmock.mockpolicy.stub;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub4Multi1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

// 使用MockPolicy对方法进行Stub时，在@BeforeClass对应方法中还未生效，在@Before、@Test对应方法中已生效
@MockPolicy({TestPolicyStub4Multi1.class})
public class TestMockPolicyStub4B extends TestMockNoSpBase {

    @BeforeClass
    public static void beforeClass() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Before
    public void init() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.MOCKED, str);
    }
}
