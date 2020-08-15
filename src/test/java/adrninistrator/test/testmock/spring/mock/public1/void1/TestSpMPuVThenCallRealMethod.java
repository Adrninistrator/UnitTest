package adrninistrator.test.testmock.spring.mock.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestSpMPuVThenCallRealMethod extends TestMockBase {

    // 对于实现类，支持Mockito.doCallRealMethod().when()，执行真实方法
    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        TestPublicVoidService1Impl testPublicVoidService1 = Mockito.mock(TestPublicVoidService1Impl.class);

        Mockito.doCallRealMethod().when(testPublicVoidService1).test1(Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.test1(stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        // 真实方法已执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    // 对于实现类，支持PowerMockito.when().thenCallRealMethod()，执行真实方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        TestPublicVoidService1Impl testPublicVoidService1 = Mockito.mock(TestPublicVoidService1Impl.class);

        PowerMockito.when(testPublicVoidService1, TestPublicVoidService1Impl.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenCallRealMethod();

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.test1(stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        // 真实方法已执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
