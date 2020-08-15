package adrninistrator.test.testmock.non_static.suppress.constructor;

import com.adrninistrator.non_static.TestNonStatic3;
import com.adrninistrator.non_static.TestNonStatic4;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertThrows;

// PowerMockito.suppress禁止构造函数不需要使用@PrepareForTest注解
// PowerMockito.suppress(PowerMockito.constructor())只支持禁止包含一个构造函数的类，不支持禁止包含多个构造函数的类
public class TestNStSuppressConstructor1 extends TestNStSuppressConstructorBase {

    @Test
    public void test1() {
        PowerMockito.suppress(PowerMockito.constructor(TestNonStatic3.class));

        TestNonStatic3 testNonStatic3 = new TestNonStatic3();

        checkMember(testNonStatic3, false);
    }

    @Test
    public void test2() {
        // PowerMockito.constructor不支持存在多个构造函数的类，应出现指定异常
        assertThrows(Exception.class, () ->
                PowerMockito.constructor(TestNonStatic4.class)
        );
    }
}
