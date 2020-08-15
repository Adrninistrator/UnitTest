package adrninistrator.test.testmock.spring.spy.public1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 什么也不做
public class TestSpSPuVDoNothing extends TestSpringSpyPublicVoidBase {

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doNothing().when(testPublicVoidService1Spy).test1(Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1Spy.test1(stringBuilder);

        // 什么也没做
        assertEquals(0, stringBuilder.length());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doNothing().doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1Spy).test1
                (Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1Spy.test1(stringBuilder);

        // 第1次执行，什么也没做
        assertEquals(0, stringBuilder.length());

        // 第2次执行，抛出指定异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicVoidService1Spy.test1(stringBuilder)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
