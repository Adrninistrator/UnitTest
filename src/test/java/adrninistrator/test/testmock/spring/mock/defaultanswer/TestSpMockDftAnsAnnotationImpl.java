package adrninistrator.test.testmock.spring.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/*
    设置默认Answer，执行真实方法
    使用实现类的Mock对象
    通过@Mock注解的answer属性指定默认Answer
 */
public class TestSpMockDftAnsAnnotationImpl extends TestMockBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private TestPublicNonVoidService1Impl testPublicNonVoidService1;

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        // 已执行真实方法
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1));
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
}
