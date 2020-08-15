package adrninistrator.test.testmock.non_static.mock.constructor.witharg;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.non_static.TestNonStaticWithArg1;
import com.adrninistrator.service.TestService1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Stub有参数构造函数，不使用@PrepareForTest注解
// Stub条件为指定值的参数
public class TestNStMConstructorWithArgNPSpecified extends TestMockBase {

    @Autowired
    private TestService1 testService1;

    @Before
    public void init() throws Exception {

        TestNonStaticWithArg1 testNonStaticWithArg1Mock = Mockito.mock(TestNonStaticWithArg1.class);
        Mockito.when(testNonStaticWithArg1Mock.test1()).thenReturn(TestConstants.MOCKED);

        // 构造函数的Stub条件设置为一个指定值的String参数
        PowerMockito.whenNew(TestNonStaticWithArg1.class).withArguments(TestConstants.FLAG1).thenReturn
                (testNonStaticWithArg1Mock);
    }

    @Test
    public void test1() {
        TestNonStaticWithArg1 testNonStaticWithArg1 = new TestNonStaticWithArg1(TestConstants.FLAG1);

        // 对TestNonStaticWithArg1构造函数进行Stub生效
        assertEquals(TestConstants.MOCKED, testNonStaticWithArg1.test1());
    }

    @Test
    public void test2() {
        TestNonStaticWithArg1 testNonStaticWithArg1 = new TestNonStaticWithArg1(TestConstants.FLAG2);

        // 调用构造函数不满足Stub方法，生成对象为null
        assertNull(testNonStaticWithArg1);
    }

    @Test
    public void test3() {
        TestNonStaticWithArg1 testNonStaticWithArg1 = testService1.genWithArg1(TestConstants.FLAG1);

        // 未通过@PrepareForTest注解指定调用构造函数的被测试类，对构造函数Stub不生效
        assertEquals(TestConstants.NOT_MOCKED, testNonStaticWithArg1.test1());
    }
}
