package adrninistrator.test.testmock.mockpolicy.replace;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.replace.TestPolicyReplace2;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 在PowerMockPolicy实现类TestPolicyReplace2中对TestStaticPublicNonVoid1、TestPublicNonVoidService1Impl类的方法进行了Replace，抛出异常
@MockPolicy(TestPolicyReplace2.class)
public class TestMockPolicyReplace2 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid1.test1("", null)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() {
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicNonVoidService1.test1("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
