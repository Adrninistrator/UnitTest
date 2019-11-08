package test.testmock.spring.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//设置默认Answer，执行真实方法
//使用实现类的Mock对象
public class TestSpMockDftAnsCallsRealMethods2 extends TestMockBase {

    private TestPublicNonVoidService1Impl testPublicNonVoidService1;

    @Before
    public void init() {

        /*
            对实现类执行Mockito.mock
            通过Mockito.withSettings().defaultAnswer指定CallsRealMethods
            未Stub的方法会执行真实方法
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1Impl.class, Mockito.withSettings()
                .defaultAnswer(new CallsRealMethods()));
    }

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

    //被Stub的方法不受默认Answer的影响
    @Test
    public void test3() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST3);

        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1).test3(Mockito.anyString());

        String str = testPublicNonVoidService1.test3("");

        Assert.assertEquals(TestConstants.MOCKED, str);

        //未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
