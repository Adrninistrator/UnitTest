package adrninistrator.test.testmock.spring.spy.public1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 执行真实方法
public class TestSpSPuVThenCallRealMethod extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doCallRealMethod().when(testPublicVoidService1Spy).test1(Mockito.any(StringBuilder.class));

        // Mockito.doCallRealMethod()未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));

        StringBuilder stringBuilder = new StringBuilder();

        testPublicVoidService1Spy.test1(stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());

        // 真实方法执行了1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
