package adrninistrator.test.testmock.spring.mock.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数，使用Captor获取调用参数
public class TestSpMPuVVerifyCaptor extends TestMockBase {

    @Test
    public void test() {
        ArgumentCaptor<StringBuilder> argCaptor1 = ArgumentCaptor.forClass(StringBuilder.class);

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        // 初始，执行次数为0
        Mockito.verify(testPublicVoidService1, Mockito.times(0)).test1(Mockito.any(StringBuilder.class));

        testPublicVoidService1.test1(new StringBuilder().append(TestConstants.FLAG1));

        // 执行一次后，执行次数为1
        Mockito.verify(testPublicVoidService1, Mockito.times(1)).test1(argCaptor1.capture());

        assertEquals(TestConstants.FLAG1, argCaptor1.getValue().toString());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
