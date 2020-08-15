package adrninistrator.test.testmock.spring.spy.public1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
public class TestSpSPuVThenThrow extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1Spy).test1(Mockito.any
                (StringBuilder.class));

        // Mockito.doThrow不执行真实方法，真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));

        // 满足Stub条件，抛出异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicVoidService1Spy.test1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
