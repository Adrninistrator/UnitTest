package adrninistrator.test.testmock.spring.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ThrowsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/*
    设置默认Answer，抛出异常
    使用Mockito.mock()方法生成Mock对象
 */
public class TestSpMockDftAnsThrowsExpt1 extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {
        /*
            对实现类执行Mockito.mock
            指定默认Answer抛出异常
            未Stub的方法会抛出指定异常
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class, new ThrowsException(new RuntimeException(TestConstants.MOCKED)));
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicNonVoidService1.test1("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicNonVoidService1.test2("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST2));
    }
}
