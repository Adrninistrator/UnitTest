package adrninistrator.test.testmock.spring.mock.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import java.util.List;

import static org.junit.Assert.assertEquals;

// 使用verify判断方法的执行次数，并使用Captor获取调用参数
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVVerifyCaptor extends TestMockBase {

    @Test
    public void test() throws Exception {

        ArgumentCaptor<StringBuilder> argCaptor1a = ArgumentCaptor.forClass(StringBuilder.class);

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl
                .class);

        // 执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder()
                .append(TestConstants.FLAG1));

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1a.capture());

        check1(argCaptor1a);

        // 执行testPrivateVoidService1的test1()方法
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, new StringBuilder()
                .append(TestConstants.FLAG2));

        ArgumentCaptor<StringBuilder> argCaptor1b = ArgumentCaptor.forClass(StringBuilder.class);

        PowerMockito.verifyPrivate(testPrivateVoidService1, Mockito.times(2));
        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1,
                argCaptor1b.capture());

        check2(argCaptor1b);
    }

    private void check1(ArgumentCaptor<StringBuilder> argCaptor1) {
        assertEquals(TestConstants.FLAG1, argCaptor1.getValue().toString());

        List<StringBuilder> args = argCaptor1.getAllValues();

        assertEquals(1, args.size());
        assertEquals(TestConstants.FLAG1, args.get(0).toString());
    }

    private void check2(ArgumentCaptor<StringBuilder> argCaptor1) {
        assertEquals(TestConstants.FLAG2, argCaptor1.getValue().toString());

        List<StringBuilder> args = argCaptor1.getAllValues();

        assertEquals(2, args.size());
        assertEquals(TestConstants.FLAG1, args.get(0).toString());
        assertEquals(TestConstants.FLAG2, args.get(1).toString());
    }
}
