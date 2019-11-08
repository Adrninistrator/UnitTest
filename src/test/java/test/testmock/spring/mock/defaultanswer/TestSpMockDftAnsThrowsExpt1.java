package test.testmock.spring.mock.defaultanswer;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ThrowsException;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

public class TestSpMockDftAnsThrowsExpt1 extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {

        /*
            对实现类执行Mockito.mock
            通过Mockito.withSettings().defaultAnswer指定ThrowsException
            未Stub的方法会抛出指定异常
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class, Mockito.withSettings()
                .defaultAnswer(new ThrowsException(new RuntimeException(TestConstants.MOCKED))));
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        try {

            testPublicNonVoidService1.test1("");
        } catch (Exception e) {

            //真实方法未执行
            int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                    TestPublicNonVoidService1Impl.NAME_TEST1);
            Assert.assertEquals(0, times);

            throw e;
        }
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        try {

            testPublicNonVoidService1.test2("");
        } catch (Exception e) {

            //真实方法未执行
            int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                    TestPublicNonVoidService1Impl.NAME_TEST2);
            Assert.assertEquals(0, times);

            throw e;
        }
    }
}
