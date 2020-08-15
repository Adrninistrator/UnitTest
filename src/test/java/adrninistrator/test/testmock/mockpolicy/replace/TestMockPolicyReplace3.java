package adrninistrator.test.testmock.mockpolicy.replace;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.replace.TestPolicyReplace3;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 在PowerMockPolicy实现类TestPolicyReplace3中对TestStaticPublicNonVoid1、TestPublicNonVoidService1Impl类的方法进行了Replace，执行真实方法
@MockPolicy(TestPolicyReplace3.class)
public class TestMockPolicyReplace3 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test2() {
        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
