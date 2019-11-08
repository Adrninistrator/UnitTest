package test.testmock.spring.spy.public1.void1;

import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

//使用verify判断方法的执行次数
public class TestSpSPuVVerify extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {

        //初始，执行次数为0
        Mockito.verify(testPublicVoidService1Spy, Mockito.times(0)).test1(Mockito.any(StringBuffer.class));

        testPublicVoidService1Spy.test1(new StringBuffer());

        //执行一次后，执行次数为1
        Mockito.verify(testPublicVoidService1Spy, Mockito.times(1)).test1(Mockito.any(StringBuffer.class));

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
