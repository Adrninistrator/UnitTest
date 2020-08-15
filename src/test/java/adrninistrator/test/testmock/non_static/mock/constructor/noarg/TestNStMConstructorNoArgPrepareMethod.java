package adrninistrator.test.testmock.non_static.mock.constructor.noarg;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import com.adrninistrator.service.TestService1;
import com.adrninistrator.service.impl.TestService1Impl;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Stub无参数构造函数，在测试方法级别使用@PrepareForTest注解
// 在被测试代码调用构造函数，Stub生效
public class TestNStMConstructorNoArgPrepareMethod extends TestNStMConstructorNoArgBase {

    @Autowired
    private TestService1 testService1;

    @PrepareForTest({TestService1Impl.class})
    @Test
    public void test() {
        TestNonStaticNoArg1 testNonStaticNoArg1 = testService1.genNoArg1();

        /*
            TestNonStaticNoArg1构造函数在TestService1Impl.testNonStaticNonVoid1方法中调用
            在当前方法通过@PrepareForTest指定TestService1Impl.class，对构造函数Stub生效
         */
        assertEquals(TestConstants.MOCKED, testNonStaticNoArg1.test1());
    }
}
