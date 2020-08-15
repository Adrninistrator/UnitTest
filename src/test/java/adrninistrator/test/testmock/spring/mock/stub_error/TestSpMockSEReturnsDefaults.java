package adrninistrator.test.testmock.spring.mock.stub_error;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestSpMockSEReturnsDefaults extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1Mock;

    private TestPublicNonVoidService1 testPublicNonVoidService1ImplMock;

    @Before
    public void init() {
        /*
            对接口执行Mockito.mock
            指定默认Answer为默认的返回空值的Answer
            未Stub的方法不会执行真实方法
        */
        testPublicNonVoidService1Mock = Mockito.mock(TestPublicNonVoidService1.class);

        /*
            对实现类执行Mockito.mock
            指定默认Answer为默认的返回空值的Answer
            未Stub的方法会执行真实方法
        */
        testPublicNonVoidService1ImplMock = Mockito.mock(TestPublicNonVoidService1Impl.class);

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1);
    }

    @Test
    public void test1() {
        Mockito.when(testPublicNonVoidService1Mock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        // 对于接口的Mock对象，Mockito.when().thenReturn()未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        Mockito.when(testPublicNonVoidService1ImplMock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        // 对于实现类的Mock对象，Mockito.when().thenReturn()未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test3() {
        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1ImplMock).test1(Mockito.anyString());

        // 对于实现类的Mock对象，Mockito.doReturn未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
