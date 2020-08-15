package adrninistrator.test.testmock.mockpolicy.suppress;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.suppress.TestPolicySuppress4;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

/*
    在PowerMockPolicy实现类TestPolicySuppress4中
    分别禁止了TestStaticPublicNonVoid1类的test1方法，TestServiceB1Impl类的test1方法
    使用settings.addMethodsToSuppress方法，参数为Method数组
 */
@MockPolicy(TestPolicySuppress4.class)
public class TestMockPolicySuppress4 extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertNull(str);
    }

    @Test
    public void test2() {
        String str = testServiceB1.test1("");
        assertNull(str);
    }
}
