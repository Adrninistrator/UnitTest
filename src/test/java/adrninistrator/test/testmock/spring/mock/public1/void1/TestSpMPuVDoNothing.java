package adrninistrator.test.testmock.spring.mock.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestSpMPuVDoNothing extends TestMockBase {

    @Test
    public void test1() {
        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doNothing().when(testPublicVoidService1).test1(Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.test1(stringBuilder);

        assertEquals(0, stringBuilder.length());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doNothing().doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1).test1
                (Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1.test1(stringBuilder);

        // 第一次执行时，什么也没做
        assertEquals(0, stringBuilder.length());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1));

        // 第二次执行时，抛出异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicVoidService1.test1(stringBuilder)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
