package adrninistrator.test.testmock.spring.mock.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 使用Answer实现回调
public class TestSpMPuVThenAnswer extends TestMockBase {

    @Test
    public void test1() {
        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doAnswer(invocation -> {

            StringBuilder arg = invocation.getArgument(0);

            assertEquals(TestConstants.FLAG1, arg.toString());

            arg.setLength(0);
            arg.append(TestConstants.MOCKED);

            return null;
        }).when(testPublicVoidService1).test1(Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TestConstants.FLAG1);

        testPublicVoidService1.test1(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        PowerMockito.doAnswer(invocation -> {

            invocation.callRealMethod();

            return null;
        }).when(testPublicVoidService1).test1(Mockito.any(StringBuilder.class));

        // 不支持对接口的Mock对象执行真实方法，应出现指定异常
        assertThrows(Exception.class, () ->
                testPublicVoidService1.test1(new StringBuilder())
        );
    }

    @Test
    public void test3() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        TestPublicVoidService1Impl testPublicVoidService1 = Mockito.mock(TestPublicVoidService1Impl.class);

        PowerMockito.doAnswer(invocation -> {

            invocation.callRealMethod();

            return null;
        }).when(testPublicVoidService1).test1(Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.test1(stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
