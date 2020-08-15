package adrninistrator.test.testmock.spring.spy.other;

import adrninistrator.test.testmock.spring.spy.public1.non_void.TestSpringSpyPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 未Stub的方法的返回值
public class TestSpSpyUnstubbedMethod extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test() {
        String str = testPublicNonVoidService1Spy.test3("");
        // 未Stub的方法，返回真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
