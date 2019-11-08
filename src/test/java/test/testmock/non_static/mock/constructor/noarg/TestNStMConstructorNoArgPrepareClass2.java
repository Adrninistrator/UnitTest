package test.testmock.non_static.mock.constructor.noarg;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStatic1;
import com.test.non_static.TestNonStaticNoArg1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

//Stub无参数构造函数
//在被测试代码的内部类调用构造函数，在测试代码中使用@PrepareForTest注解的value属性指定被测试类，Stub不生效
@PrepareForTest(TestNonStaticNoArg1.class)
public class TestNStMConstructorNoArgPrepareClass2 extends TestNStMConstructorNoArgBase {

    @Test
    public void test1() {

        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        TestNonStaticNoArg1 testNonStaticNoArg1 = testNonStatic1.test1();

        Assert.assertEquals(TestConstants.NOT_MOCKED, testNonStaticNoArg1.test1());
    }

    @Test
    public void test2() {

        TestNonStatic1 testNonStatic1 = new TestNonStatic1();

        TestNonStaticNoArg1 testNonStaticNoArg1 = testNonStatic1.test2();

        Assert.assertEquals(TestConstants.NOT_MOCKED, testNonStaticNoArg1.test1());
    }
}
