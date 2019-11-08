package test.testmock.non_static.suppress.constructor;

import com.test.non_static.TestNonStatic3;
import com.test.non_static.TestNonStatic4;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

//PowerMockito.suppress禁止构造函数不需要使用@PrepareForTest注解
//PowerMockito.suppress(PowerMockito.constructorsDeclaredIn())支持禁止类的全部构造函数
public class TestNStSuppressConstructorsDeclaredIn1 extends TestNStSuppressConstructorBase {

    @Test
    public void test1() {

        PowerMockito.suppress(PowerMockito.constructorsDeclaredIn(TestNonStatic3.class));

        TestNonStatic3 testNonStatic3 = new TestNonStatic3();

        checkMember(testNonStatic3, false);
    }

    @Test
    public void test2() {

        PowerMockito.suppress(PowerMockito.constructorsDeclaredIn(TestNonStatic4.class));

        TestNonStatic4 testNonStatic4_a = new TestNonStatic4();

        checkMember(testNonStatic4_a, false);

        TestNonStatic4 testNonStatic4_b = new TestNonStatic4("");

        checkMember(testNonStatic4_b, false);
    }
}
