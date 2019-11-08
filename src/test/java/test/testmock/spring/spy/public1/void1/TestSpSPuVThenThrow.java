package test.testmock.spring.spy.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;

//抛出异常
public class TestSpSPuVThenThrow extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1Spy).test1(Mockito.any
                (StringBuffer.class));

        //Mockito.doThrow不执行真实方法，真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));

        //满足Stub条件，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicVoidService1Spy.test1(new StringBuffer());
    }
}
