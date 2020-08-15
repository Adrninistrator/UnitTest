package adrninistrator.test.testmock.spring.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数，使用Captor获取调用参数
public class TestSpMPuNVVerifyCaptor extends TestMockBase {

    @Test
    public void test() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        // 执行次数应为0
        Mockito.verify(testPublicNonVoidService1, Mockito.times(0)).test1(Mockito.anyString());

        ArgumentCaptor<String> argCaptor1 = ArgumentCaptor.forClass(String.class);

        // 执行方法
        testPublicNonVoidService1.test1(TestConstants.FLAG1);

        // 执行次数应为1，并获取执行参数
        Mockito.verify(testPublicNonVoidService1, Mockito.times(1)).test1(argCaptor1.capture());

        // 执行方法时的参数应符合预期
        assertEquals(TestConstants.FLAG1, argCaptor1.getValue());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

}
