package test.testmock.non_static.suppress.constructor;

import com.test.non_static.TestNonStatic2;
import com.test.non_static.TestNonStatic3;
import com.test.non_static.TestNonStatic4;
import com.test.non_static.TestNonStaticWithArg2;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassIsInstance;

import java.lang.reflect.Constructor;

//PowerMockito.suppress禁止构造函数不需要使用@PrepareForTest注解
//PowerMockito.suppress(PowerMockito.constructorsDeclaredIn支持禁止类的默认构造函数
public class TestNStSuppressDefaultConstructorIn1 extends TestNStSuppressConstructorBase {

    @Test
    public void test1() {

        //仅存在一个无参数构造函数类，Suppress无参数构造函数成功
        PowerMockito.suppress(PowerMockito.defaultConstructorIn(TestNonStatic3.class));

        TestNonStatic3 testNonStatic3 = new TestNonStatic3();

        checkMember(testNonStatic3, false);
    }

    @Test
    public void test2() {

        //存在多个构造函数的类，Suppress无参数构造函数成功
        PowerMockito.suppress(PowerMockito.defaultConstructorIn(TestNonStatic4.class));

        TestNonStatic4 testNonStatic4_a = new TestNonStatic4();

        checkMember(testNonStatic4_a, false);

        TestNonStatic4 testNonStatic4_b = new TestNonStatic4("");

        checkMember(testNonStatic4_b, true);
    }

    @Test
    public void test3() {

        //无构造函数的类会自动添加一个无参数构造函数
        Constructor constructor = PowerMockito.defaultConstructorIn(TestNonStatic2.class);
        Assert.assertNotNull(constructor);
        Assert.assertEquals(0, constructor.getParameterCount());
    }

    @Test
    public void test4() {

        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        //存在有参数构造函数，但不存在无参数构造函数的类，不存在默认构造函数，PowerMockito.defaultConstructorIn()应出现指定异常
        PowerMockito.defaultConstructorIn(TestNonStaticWithArg2.class);
    }
}
