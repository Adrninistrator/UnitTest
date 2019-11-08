package test.testmock.spring.spy.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;

//抛出异常
public class TestSpSPuNVThenThrow extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.when(testPublicNonVoidService1Spy.test1(TestConstants.FLAG1)).thenThrow(new RuntimeException
                (TestConstants.MOCKED));

        //Mockito.when执行了一次真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        //满足Stub条件，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicNonVoidService1Spy).test1
                (TestConstants.FLAG1);

        //Mockito.doThrow未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        //满足Stub条件，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);
    }
}
