package adrninistrator.test.testmock.spring.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
    设置默认Answer，执行真实方法
    使用实现类的Mock对象
    通过@Mock注解的answer属性指定默认Answer
 */
public class TestSpMockDftAnsAnnotationInterface extends TestMockBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        // 未执行真实方法
        assertNull(str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        String str = testPublicNonVoidService1.test2("");

        // 未执行真实方法
        assertNull(str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST2));
    }
}
