package test.testmock.spring.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//设置默认Answer，执行真实方法
//使用实现类的Mock对象
//通过@Mock注解的answer属性指定默认Answer
public class TestSpMockDftAnsAnnotation extends TestMockBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private TestPublicNonVoidService1Impl testPublicNonVoidService1;

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        //已执行真实方法
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);
        Assert.assertEquals(1, times);
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        //会执行真实方法，由于testTableMapper对象为空，会出现空指针异常
        expectedException.expect(new TestMatcherExpClassEquals(NullPointerException.class));

        try {

            testPublicNonVoidService1.test2("");
        } catch (Exception e) {

            //真实方法执行1次
            int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                    TestPublicNonVoidService1Impl.NAME_TEST2);
            Assert.assertEquals(1, times);

            throw e;
        }
    }
}
