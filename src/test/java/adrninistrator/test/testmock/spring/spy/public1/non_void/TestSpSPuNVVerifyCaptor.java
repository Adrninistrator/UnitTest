package adrninistrator.test.testmock.spring.spy.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestSpSPuNVVerifyCaptor extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test() {
        // 执行次数应为0
        Mockito.verify(testPublicNonVoidService1Spy, Mockito.times(0)).test1(Mockito.anyString());

        ArgumentCaptor<String> argCaptor1 = ArgumentCaptor.forClass(String.class);

        // 执行方法
        testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        // 执行次数应为1，并获取执行参数
        Mockito.verify(testPublicNonVoidService1Spy, Mockito.times(1)).test1(argCaptor1.capture());

        // 执行方法时的参数应符合预期
        assertEquals(TestConstants.FLAG1, argCaptor1.getValue());

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
