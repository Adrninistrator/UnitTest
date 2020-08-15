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

import static org.junit.Assert.*;

/*
    @PrepareForTest注解在方法级别
    包含@PrepareForTest注解注解的方法的@MockPolicy注解不生效，不包含@PrepareForTest注解注解的方法的@MockPolicy注解生效
 */
@MockPolicy({TestPolicySuppress1.class, TestPolicySuppress3.class})
public class TestMockPolicyConflictSuM extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @PrepareForTest
    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.getFlag();
        assertNotNull(str);
    }

    @Test
    public void test2() {
        // 由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceB1的方法使用时会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testServiceB1.test2(null)
        );
    }

    @PrepareForTest
    @Test
    public void test3() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertNotNull(str);
    }

    @Test
    public void test4() {
        String str = testServiceB1.test1("");
        assertNull(str);
    }
}
