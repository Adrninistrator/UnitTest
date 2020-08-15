package adrninistrator.test.testmock.spring.spy.private1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSpSPrVVerifyCaptor extends TestSpringSpyPrivateVoidBase {

    @Test
    public void test() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateVoidService1Impl.class, TestPrivateVoidService1Impl.NAME_TEST1);

        ArgumentCaptor<StringBuilder> argCaptor1a = ArgumentCaptor.forClass(StringBuilder.class);

        // 执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder()
                .append(TestConstants.FLAG1));

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1a.capture());

        check1(argCaptor1a);

        // 执行testPrivateVoidService1Spy的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder()
                .append(TestConstants.FLAG2));

        ArgumentCaptor<StringBuilder> argCaptor1b = ArgumentCaptor.forClass(StringBuilder.class);

        PowerMockito.verifyPrivate(testPrivateVoidService1Spy, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1Spy, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1b.capture());

        check2(argCaptor1b);

        // 真实方法执行了两次
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateVoidService1Impl.class,
                TestPrivateVoidService1Impl.NAME_TEST1));
    }

    // 真实方法会执行，调用参数值会被修改
    private void check1(ArgumentCaptor<StringBuilder> argCaptor1) {
        assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, argCaptor1.getValue().toString());

        List<StringBuilder> args = argCaptor1.getAllValues();

        assertEquals(1, args.size());
        assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, args.get(0).toString());
    }

    private void check2(ArgumentCaptor<StringBuilder> argCaptor1) {
        assertEquals(TestConstants.FLAG2 + TestConstants.NOT_MOCKED, argCaptor1.getValue().toString());

        List<StringBuilder> args = argCaptor1.getAllValues();

        assertEquals(2, args.size());
        assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, args.get(0).toString());
        assertEquals(TestConstants.FLAG2 + TestConstants.NOT_MOCKED, args.get(1).toString());
    }
}
