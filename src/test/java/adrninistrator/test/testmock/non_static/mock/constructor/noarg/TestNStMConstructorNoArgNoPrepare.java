package adrninistrator.test.testmock.non_static.mock.constructor.noarg;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import com.adrninistrator.service.TestService1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Stub无参数构造函数，不使用@PrepareForTest注解
public class TestNStMConstructorNoArgNoPrepare extends TestNStMConstructorNoArgBase {

    @Autowired
    private TestService1 testService1;

    // 在测试代码调用构造函数
    @Test
    public void test1() {
        TestNonStaticNoArg1 testNonStaticNoArg1 = new TestNonStaticNoArg1();

        // 在测试代码执行被Stub的构造函数，在测试代码中不使用@PrepareForTest注解，Stub生效
        assertEquals(TestConstants.MOCKED, testNonStaticNoArg1.test1());
    }

    // 在被测试代码调用构造函数
    @Test
    public void test2() {
        TestNonStaticNoArg1 testNonStaticNoArg1 = testService1.genNoArg1();

        // 在被测试代码执行被Stub的构造函数，在测试代码中不使用@PrepareForTest注解，Stub不生效
        assertEquals(TestConstants.NOT_MOCKED, testNonStaticNoArg1.test1());
    }
}
