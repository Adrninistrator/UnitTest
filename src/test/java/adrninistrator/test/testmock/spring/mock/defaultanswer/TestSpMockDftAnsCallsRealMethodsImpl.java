package adrninistrator.test.testmock.spring.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/*
    设置默认Answer，执行真实方法
    使用实现类的Mock对象
    使用Mockito.mock()方法生成Mock对象
 */
public class TestSpMockDftAnsCallsRealMethodsImpl extends TestMockBase {

    private TestPublicNonVoidService1Impl testPublicNonVoidService1;

    @Before
    public void init() {
        /*
            对实现类执行Mockito.mock
            指定默认Answer为执行真实方法
            执行未Stub的方法时，会执行真实方法
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1Impl.class, new CallsRealMethods());
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        // 已执行真实方法
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        // 会执行真实方法，由于testTableMapper对象为空，会出现空指针异常
        assertThrows(NullPointerException.class, () ->
                testPublicNonVoidService1.test2("")
        );

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST2));
    }

    // 被Stub的方法不受默认Answer的影响
    @Test
    public void test3() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST3);

        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1).test3(Mockito.anyString());

        String str = testPublicNonVoidService1.test3("");

        assertEquals(TestConstants.MOCKED, str);

        // 未执行真实方法
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
