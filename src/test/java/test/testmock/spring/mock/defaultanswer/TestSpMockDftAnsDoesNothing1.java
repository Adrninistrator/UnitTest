package test.testmock.spring.mock.defaultanswer;

import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import test.testmock.base.TestMockBase;

public class TestSpMockDftAnsDoesNothing1 extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {

        /*
            对实现类执行Mockito.mock
            通过Mockito.withSettings().defaultAnswer指定DoesNothing
            未Stub的方法什么也不做
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class, Mockito.withSettings()
                .defaultAnswer(DoesNothing.doesNothing()));
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        //真实方法未执行
        Assert.assertNull(str);

        int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);
        Assert.assertEquals(0, times);
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);

        String str = testPublicNonVoidService1.test2("");

        //真实方法未执行
        Assert.assertNull(str);

        int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST2);
        Assert.assertEquals(0, times);
    }
}
