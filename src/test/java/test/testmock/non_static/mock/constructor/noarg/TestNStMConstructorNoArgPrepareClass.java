package test.testmock.non_static.mock.constructor.noarg;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStaticNoArg1;
import com.test.service.TestService1;
import com.test.service.impl.TestService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

//Stub无参数构造函数，在类级别使用@PrepareForTest注解
//在被测试代码调用构造函数，Stub生效
@PrepareForTest({TestService1Impl.class})
public class TestNStMConstructorNoArgPrepareClass extends TestNStMConstructorNoArgBase {

    @Autowired
    private TestService1 testService1;

    @Test
    public void test() {

        TestNonStaticNoArg1 testNonStaticNoArg1 = testService1.genNoArg1();

        Assert.assertEquals(TestConstants.MOCKED, testNonStaticNoArg1.test1());
    }
}
