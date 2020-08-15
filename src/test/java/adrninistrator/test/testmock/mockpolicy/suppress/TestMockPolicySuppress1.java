package adrninistrator.test.testmock.mockpolicy.suppress;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.suppress.TestPolicySuppress1;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/*
    在PowerMockPolicy实现类TestPolicySuppress1中
    分别禁止了TestStaticPublicNonVoid1类的flag变量，TestServiceB1Impl类的testServiceA1变量
    使用settings.addFieldToSuppress方法，参数为多个Field对象
 */
@MockPolicy(TestPolicySuppress1.class)
public class TestMockPolicySuppress1 extends TestMockBase {

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.getFlag();
        assertNull(str);
    }

    @Test
    public void test2() {
        // 通过反射获取testServiceB1中的testServiceA1对象非空
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, "testServiceA1");
        assertNotNull(testServiceA1InB1);

        // 由于TestServiceB1Impl类中的testServiceA1对象被禁止，在testServiceB1的方法使用时会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testServiceB1.test2(null)
        );
    }
}
