package adrninistrator.test.testmock.non_static.suppress.constructor;

import com.adrninistrator.non_static.TestNonStatic3;
import com.adrninistrator.non_static.TestNonStatic4;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.SuppressCode;

// SuppressCode.suppressConstructor禁止构造函数不需要使用@PrepareForTest注解
// SuppressCode.suppressConstructor(PowerMockito.constructorsDeclaredIn支持禁止类的默认构造函数
public class TestNStSuppressDefaultConstructorIn2 extends TestNStSuppressConstructorBase {

    @Test
    public void test1() {
        SuppressCode.suppressConstructor(PowerMockito.defaultConstructorIn(TestNonStatic3.class));

        TestNonStatic3 testNonStatic3 = new TestNonStatic3();

        checkMember(testNonStatic3, false);
    }

    @Test
    public void test2() {
        SuppressCode.suppressConstructor(PowerMockito.defaultConstructorIn(TestNonStatic4.class));

        TestNonStatic4 testNonStatic4_a = new TestNonStatic4();

        checkMember(testNonStatic4_a, false);

        TestNonStatic4 testNonStatic4_b = new TestNonStatic4("");

        checkMember(testNonStatic4_b, true);
    }
}
