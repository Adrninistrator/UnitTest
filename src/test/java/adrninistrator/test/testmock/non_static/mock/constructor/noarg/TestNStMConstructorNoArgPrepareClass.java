package adrninistrator.test.testmock.non_static.mock.constructor.noarg;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticNoArg1;
import com.adrninistrator.service.TestService1;
import com.adrninistrator.service.impl.TestService1Impl;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// Stub无参数构造函数，在类级别使用@PrepareForTest注解
// 在被测试代码调用构造函数，Stub生效
@PrepareForTest({TestService1Impl.class})
public class TestNStMConstructorNoArgPrepareClass extends TestNStMConstructorNoArgBase {

    @Autowired
    private TestService1 testService1;

    @Test
    public void test() {
        TestNonStaticNoArg1 testNonStaticNoArg1 = testService1.genNoArg1();

        assertEquals(TestConstants.MOCKED, testNonStaticNoArg1.test1());
    }
}
