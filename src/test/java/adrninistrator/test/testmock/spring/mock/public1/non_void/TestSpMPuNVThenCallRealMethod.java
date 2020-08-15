package adrninistrator.test.testmock.spring.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

// 执行真实方法
public class TestSpMPuNVThenCallRealMethod extends TestMockBase {

    // 对于接口的Mock对象，不支持Mockito.when().thenCallRealMethod()
    @Test
    public void test1() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        // 应出现指定异常
        assertThrows(Exception.class, () ->
                Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenCallRealMethod()
        );
    }

    // 对于实现类，支持Mockito.when().thenCallRealMethod()
    @Test
    public void test2() {
        TestPublicNonVoidService1Impl testPublicNonVoidService1ImplMock = Mockito.mock(TestPublicNonVoidService1Impl.class);

        Mockito.when(testPublicNonVoidService1ImplMock.test1(TestConstants.FLAG1)).thenCallRealMethod();

        String str = testPublicNonVoidService1ImplMock.test1(TestConstants.FLAG1);
        // 满足Stub条件，返回数据应为原始值
        assertEquals(TestConstants.NOT_MOCKED, str);

        // Mockito.when执行了1次真实方法
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        str = testPublicNonVoidService1ImplMock.test1("");
        // 不满足Stub条件，返回值为null
        assertNull(str);

        // 真实方法已执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test3() {
        TestPublicNonVoidService1Impl testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1Impl.class);

        Mockito.when(testPublicNonVoidService1.test2(Mockito.anyString())).thenCallRealMethod();

        // 执行真实方法，由于testTableMapper对象为空，会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testPublicNonVoidService1.test2("")
        );
    }
}
