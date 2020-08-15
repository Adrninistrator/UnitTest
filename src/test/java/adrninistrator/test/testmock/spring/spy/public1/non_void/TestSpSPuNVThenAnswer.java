package adrninistrator.test.testmock.spring.spy.public1.non_void;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用Answer实现回调
public class TestSpSPuNVThenAnswer extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.when(testPublicNonVoidService1Spy.test1(TestConstants.FLAG1)).thenAnswer(invocation -> {

            String arg = invocation.getArgument(0);

            assertEquals(TestConstants.FLAG1, arg);

            return TestConstants.MOCKED;
        });

        // Mockito.when执行了真实方法
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);

        // 满足条件，返回值为被Stub的值
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.doAnswer(invocation -> {

            String arg = invocation.getArgument(0);

            if (TestConstants.FLAG1.equals(arg)) {
                return TestConstants.MOCKED;
            } else {
                return invocation.callRealMethod();
            }
        }).when(testPublicNonVoidService1Spy).test1(TestConstants.FLAG1);

        // Mockito.do...().when()不执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        // 参数为TestConstants.FLAG1，返回值为被Mock的值
        assertEquals(TestConstants.MOCKED, str);

        str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG2);

        // 参数非TestConstants.FLAG1，返回值为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
