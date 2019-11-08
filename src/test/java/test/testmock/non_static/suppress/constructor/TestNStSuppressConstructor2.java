package test.testmock.non_static.suppress.constructor;

import com.test.non_static.TestNonStatic3;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.SuppressCode;

//SuppressCode.suppressConstructor禁止构造函数不需要使用@PrepareForTest注解
//SuppressCode.suppressConstructor(PowerMockito.constructor())只支持禁止包含一个构造函数的类，不支持禁止包含多个构造函数的类
public class TestNStSuppressConstructor2 extends TestNStSuppressConstructorBase {

    @Test
    public void test() {

        SuppressCode.suppressConstructor(PowerMockito.constructor(TestNonStatic3.class));

        TestNonStatic3 testNonStatic3 = new TestNonStatic3();

        checkMember(testNonStatic3, false);
    }
}
