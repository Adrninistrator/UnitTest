package adrninistrator.test.testmock.non_static.mock.constructor.noarg;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStatic1;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Stub无参数构造函数，不使用@PrepareForTest注解
// 在被测试代码的内部类执行被Stub的构造函数，在测试代码中不使用@PrepareForTest注解，Stub不生效
public class TestNStMConstructorNoArgNoPrepare2 extends TestNStMConstructorNoArgBase {

    @Test
    public void test1() {
        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        TestNonStaticNoArg1 testNonStaticNoArg1 = testNonStatic1.test1();

        assertEquals(TestConstants.NOT_MOCKED, testNonStaticNoArg1.test1());
    }

    @Test
    public void test2() {
        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        TestNonStaticNoArg1 testNonStaticNoArg1 = testNonStatic1.test2();

        assertEquals(TestConstants.NOT_MOCKED, testNonStaticNoArg1.test1());
    }
}
