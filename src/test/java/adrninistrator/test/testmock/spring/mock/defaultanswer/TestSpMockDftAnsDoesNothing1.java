package adrninistrator.test.testmock.spring.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
    设置默认Answer，什么也不做
    使用Mockito.mock()方法生成Mock对象
 */
public class TestSpMockDftAnsDoesNothing1 extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {
        /*
            对实现类执行Mockito.mock
            指定默认Answer什么也不做
            未Stub的方法什么也不做
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class, DoesNothing.doesNothing());
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        // 真实方法未执行
        assertNull(str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        String str = testPublicNonVoidService1.test2("");

        // 真实方法未执行
        assertNull(str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST2));
    }
}
