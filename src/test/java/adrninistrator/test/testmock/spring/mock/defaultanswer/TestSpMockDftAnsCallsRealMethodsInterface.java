package adrninistrator.test.testmock.spring.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
    设置默认Answer，执行真实方法
    使用接口的Mock对象
    使用Mockito.mock()方法生成Mock对象
 */
public class TestSpMockDftAnsCallsRealMethodsInterface extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {
        /*
            对接口执行Mockito.mock
            指定默认Answer为执行真实方法
            执行未Stub的方法时，不会执行真实方法
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class, new CallsRealMethods());
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        // 未执行真实方法
        assertNull(str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
