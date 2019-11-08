package test.testmock.spring.mock.defaultanswer;

import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import test.testmock.base.TestMockBase;

//设置默认Answer，执行真实方法
//使用接口的Mock对象
public class TestSpMockDftAnsCallsRealMethods1 extends TestMockBase {

    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {

        /*
            对接口执行Mockito.mock
            指定CallsRealMethods为默认Answer
            未Stub的方法不执行真实方法
        */
        testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class, new CallsRealMethods());
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);

        String str = testPublicNonVoidService1.test1("");

        //未执行真实方法
        Assert.assertNull(str);

        int times = TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1);
        Assert.assertEquals(0, times);
    }
}
