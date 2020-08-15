package adrninistrator.test.testmock.non_static.mock.constructor.noarg;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStatic1;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Stub无参数构造函数
// 在被测试代码的内部类调用构造函数，在测试代码中使用@PrepareForTest注解的fullyQualifiedNames属性指定被测试类所在的包，Stub生效
@PrepareForTest(fullyQualifiedNames = "com.adrninistrator.non_static.*")
public class TestNStMConstructorNoArgPrepareName extends TestNStMConstructorNoArgBase {

    @Test
    public void test1() {
        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        TestNonStaticNoArg1 testNonStaticNoArg1 = testNonStatic1.test1();

        assertEquals(TestConstants.MOCKED, testNonStaticNoArg1.test1());
    }

    @Test
    public void test2() {
        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        TestNonStaticNoArg1 testNonStaticNoArg1 = testNonStatic1.test2();

        assertEquals(TestConstants.MOCKED, testNonStaticNoArg1.test1());
    }
}
