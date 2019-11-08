package test.testmock.spring.spy.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;

//什么也不做
public class TestSpSPuVDoNothing extends TestSpringSpyPublicVoidBase {

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doNothing().when(testPublicVoidService1Spy).test1(Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1Spy.test1(stringBuffer);

        //什么也没做
        Assert.assertEquals(0, stringBuffer.length());

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doNothing().doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1Spy).test1
                (Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1Spy.test1(stringBuffer);

        //第1次执行，什么也没做
        Assert.assertEquals(0, stringBuffer.length());

        //第2次执行，抛出指定异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicVoidService1Spy.test1(stringBuffer);

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
