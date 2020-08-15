package adrninistrator.test.testmock.spring.mock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// 被Stub方法条件不满足的返回值
public class TestSpMockStubNotSatisfied1 extends TestMockBase {

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock;

    // 测试Mockito.mock返回的对象
    @Test
    public void test1() {
        doTest(Mockito.mock(TestPublicNonVoidService1.class));
    }

    // 测试@Mock注解产生的对象
    @Test
    public void test2() {
        doTest(testPublicNonVoidService1Mock);
    }

    private void doTest(TestPublicNonVoidService1 testPublicNonVoidService1) {
        Mockito.when(testPublicNonVoidService1.test3(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);

        String str = testPublicNonVoidService1.test3(TestConstants.FLAG1);
        // 被Stub的方法，参数满足条件时，返回指定的值
        assertEquals(TestConstants.MOCKED, str);

        str = testPublicNonVoidService1.test3("");
        // 被Stub的方法，参数不满足条件时，返回值为null
        assertNull(str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
