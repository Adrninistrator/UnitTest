package adrninistrator.test.testmock.spring.spy.public1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 使用Answer实现回调
public class TestSpSPuVThenAnswer extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {
        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doAnswer(invocation -> {

            StringBuilder arg = invocation.getArgument(0);

            if (TestConstants.FLAG1.equals(arg.toString())) {
                arg.setLength(0);
                arg.append(TestConstants.MOCKED);

                return null;
            } else {
                invocation.callRealMethod();

                return null;
            }
        }).when(testPublicVoidService1Spy).test1(Mockito.any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TestConstants.FLAG1);

        testPublicVoidService1Spy.test1(stringBuilder);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));

        // 参数为TestConstants.FLAG1，执行Stub的操作
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG2);

        testPublicVoidService1Spy.test1(stringBuilder);

        // 参数非TestConstants.FLAG1，参数值为真实方法设置的值
        assertEquals(TestConstants.FLAG2 + TestConstants.NOT_MOCKED, stringBuilder.toString());

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
