package adrninistrator.test.testmock.spring.mock.stub_error;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ThrowsException;

import static org.junit.Assert.assertThrows;

public class TestSpMockSEThrowsExpt extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1Mock;

    private TestPublicNonVoidService1 testPublicNonVoidService1ImplMock;

    @Before
    public void init() {
        /*
            对接口执行Mockito.mock
            指定默认Answer执行真实方法
            未Stub的方法不会执行真实方法
        */
        testPublicNonVoidService1Mock = Mockito.mock(TestPublicNonVoidService1.class,
                new ThrowsException(new RuntimeException(TestConstants.MOCKED)));

        /*
            对实现类执行Mockito.mock
            指定默认Answer执行真实方法
            未Stub的方法会执行真实方法
        */
        testPublicNonVoidService1ImplMock = Mockito.mock(TestPublicNonVoidService1Impl.class,
                new ThrowsException(new RuntimeException(TestConstants.MOCKED)));

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1);
    }

    @Test
    public void test1() {
        // 对于接口的Mock对象，Mockito.when().thenReturn()会抛出异常
        assertThrows(RuntimeException.class, () ->
                Mockito.when(testPublicNonVoidService1Mock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED)
        );
    }

    @Test
    public void test2() {
        // 对于实现类的Mock对象，Mockito.when().thenReturn()会抛出异常
        assertThrows(RuntimeException.class, () ->
                Mockito.when(testPublicNonVoidService1ImplMock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED)
        );
    }

    @Test
    public void test3() {
        // 对于实现类的Mock对象，Mockito.doReturn未抛出异常
        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1ImplMock).test1(Mockito.anyString());
    }
}
