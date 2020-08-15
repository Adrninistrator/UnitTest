package adrninistrator.test.testmock.spring.spy.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数
public class TestSpSPuNVVerify extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test() {
        Mockito.verify(testPublicNonVoidService1Spy, Mockito.times(0)).test1(Mockito.anyString());

        testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        // 执行一次后，执行次数为1
        Mockito.verify(testPublicNonVoidService1Spy, Mockito.times(1)).test1(Mockito.anyString());
        Mockito.verify(testPublicNonVoidService1Spy, Mockito.times(1)).test1(TestConstants.FLAG1);
        // 参数不满足，执行次数为0
        Mockito.verify(testPublicNonVoidService1Spy, Mockito.times(0)).test1(TestConstants.FLAG2);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
