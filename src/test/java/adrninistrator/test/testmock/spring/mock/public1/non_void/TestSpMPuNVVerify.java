package adrninistrator.test.testmock.spring.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数
public class TestSpMPuNVVerify extends TestMockBase {

    @Test
    public void test() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        // 初始，执行次数为0
        Mockito.verify(testPublicNonVoidService1, Mockito.times(0)).test1(Mockito.anyString());

        testPublicNonVoidService1.test1(TestConstants.FLAG1);

        // 执行一次后，执行次数为1
        Mockito.verify(testPublicNonVoidService1, Mockito.times(1)).test1(Mockito.anyString());
        Mockito.verify(testPublicNonVoidService1, Mockito.times(1)).test1(TestConstants.FLAG1);
        // 参数不满足，执行次数为0
        Mockito.verify(testPublicNonVoidService1, Mockito.times(0)).test1(TestConstants.FLAG2);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
