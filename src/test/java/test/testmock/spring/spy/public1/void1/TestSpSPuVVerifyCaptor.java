package test.testmock.spring.spy.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

//使用verify判断方法的执行次数，并使用Captor获取调用参数
public class TestSpSPuVVerifyCaptor extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {

        ArgumentCaptor<StringBuffer> argCaptor1 = ArgumentCaptor.forClass(StringBuffer.class);

        //初始，执行次数为0
        Mockito.verify(testPublicVoidService1Spy, Mockito.times(0)).test1(Mockito.any(StringBuffer.class));

        testPublicVoidService1Spy.test1(new StringBuffer().append(TestConstants.FLAG1));

        //执行一次后，执行次数为1
        Mockito.verify(testPublicVoidService1Spy, Mockito.times(1)).test1(argCaptor1.capture());

        //真实方法执行后，传入参数值内容发生改变
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, argCaptor1.getValue().toString());

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
