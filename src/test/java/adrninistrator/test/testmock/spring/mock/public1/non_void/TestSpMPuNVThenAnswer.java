package adrninistrator.test.testmock.spring.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用Answer实现回调
public class TestSpMPuNVThenAnswer extends TestMockBase {

    @Test
    public void test() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenAnswer(invocation -> {

            String arg = invocation.getArgument(0);

            assertEquals(TestConstants.FLAG1, arg);

            return TestConstants.MOCKED;
        });

        String str = testPublicNonVoidService1.test1(TestConstants.FLAG1);

        // 满足条件，返回值为被Stub的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
