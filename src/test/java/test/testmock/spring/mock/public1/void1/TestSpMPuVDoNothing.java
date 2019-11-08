package test.testmock.spring.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

public class TestSpMPuVDoNothing extends TestMockBase {

    @Test
    public void test1() {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doNothing().when(testPublicVoidService1).test1(Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.test1(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doNothing().doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1).test1
                (Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.test1(stringBuffer);

        //第一次执行时，什么也没做
        Assert.assertEquals(0, stringBuffer.length());

        //真实方法未执行
        int times = TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl
                .NAME_TEST1);
        Assert.assertEquals(0, times);

        //第二次执行时，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicVoidService1.test1(stringBuffer);
    }
}
