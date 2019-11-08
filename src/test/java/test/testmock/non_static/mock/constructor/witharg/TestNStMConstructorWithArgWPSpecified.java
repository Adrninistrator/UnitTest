package test.testmock.non_static.mock.constructor.witharg;

import com.test.common.TestConstants;
import com.test.non_static.TestNonStaticWithArg1;
import com.test.service.TestService1;
import com.test.service.impl.TestService1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//Stub有参数构造函数，使用@PrepareForTest注解
//Stub条件为指定值的参数
@PrepareForTest({TestService1Impl.class})
public class TestNStMConstructorWithArgWPSpecified extends TestMockBase {

    @Autowired
    private TestService1 testService1;

    @Before
    public void init() throws Exception {

        TestNonStaticWithArg1 testNonStaticWithArg1Mock = Mockito.mock(TestNonStaticWithArg1.class);
        Mockito.when(testNonStaticWithArg1Mock.test1()).thenReturn(TestConstants.MOCKED);

        //构造函数的Stub条件设置为一个指定值的String参数
        PowerMockito.whenNew(TestNonStaticWithArg1.class).withArguments(TestConstants.FLAG1).thenReturn
                (testNonStaticWithArg1Mock);
    }

    @Test
    public void test1() {

        TestNonStaticWithArg1 testNonStaticWithArg1 = testService1.genWithArg1(TestConstants.FLAG1);

        //通过@PrepareForTest注解指定调用构造函数的被测试类，对构造函数Stub生效
        Assert.assertEquals(TestConstants.MOCKED, testNonStaticWithArg1.test1());
    }

    @Test
    public void test2() {

        TestNonStaticWithArg1 testNonStaticWithArg1 = testService1.genWithArg2(TestConstants.FLAG1, TestConstants
                .FLAG1);

        //调用构造函数方法不满足Stub方法，生成对象为null
        Assert.assertNull(testNonStaticWithArg1);
    }
}
