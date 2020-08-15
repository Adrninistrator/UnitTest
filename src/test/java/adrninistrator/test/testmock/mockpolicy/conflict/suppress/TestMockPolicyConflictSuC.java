package adrninistrator.test.testmock.mockpolicy.conflict.suppress;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.suppress.TestPolicySuppress1;
import adrninistrator.test.testmock.mockpolicy.policy.suppress.TestPolicySuppress3;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/*
    @PrepareForTest注解在类级别
    全部方法@MockPolicy注解不生效
 */
@MockPolicy({TestPolicySuppress1.class, TestPolicySuppress3.class})
@PrepareForTest
public class TestMockPolicyConflictSuC extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.getFlag();
        assertNotNull(str);
    }

    @Test
    public void test2() {
        StringBuilder stringBuilder = new StringBuilder();
        testServiceB1.test2(stringBuilder);
        assertTrue(stringBuilder.length() > 0);
    }

    @Test
    public void test3() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertNotNull(str);
    }

    @Test
    public void test4() {
        String str = testServiceB1.test1("");
        assertNotNull(str);
    }
}
