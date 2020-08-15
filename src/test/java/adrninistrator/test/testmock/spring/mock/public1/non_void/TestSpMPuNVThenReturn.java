package adrninistrator.test.testmock.spring.mock.public1.non_void;

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

// 修改返回值
public class TestSpMPuNVThenReturn extends TestMockBase {

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock;

    // 使用Mockito.mock
    @Test
    public void test1() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);

        String str = testPublicNonVoidService1.test1(TestConstants.FLAG1);
        // 满足条件，返回值为被Stub的值
        assertEquals(TestConstants.MOCKED, str);

        str = testPublicNonVoidService1.test1("");
        // 不满足Stub条件，返回值为null
        assertNull(str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    // 使用@Mock，与Mockito.mock返回对象效果相同
    @Test
    public void test2() {
        Mockito.when(testPublicNonVoidService1Mock.test1(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);

        String str = testPublicNonVoidService1Mock.test1(TestConstants.FLAG1);

        // 满足条件，返回值为被Stub的值
        assertEquals(TestConstants.MOCKED, str);

        str = testPublicNonVoidService1Mock.test1("");
        // 不满足Stub条件，返回值为null
        assertNull(str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
