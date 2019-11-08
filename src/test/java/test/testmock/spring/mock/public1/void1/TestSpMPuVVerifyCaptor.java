package test.testmock.spring.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import test.testmock.base.TestMockBase;

//使用verify判断方法的执行次数，使用Captor获取调用参数
public class TestSpMPuVVerifyCaptor extends TestMockBase {

    @Test
    public void test() {

        ArgumentCaptor<StringBuffer> argCaptor1 = ArgumentCaptor.forClass(StringBuffer.class);

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        //初始，执行次数为0
        Mockito.verify(testPublicVoidService1, Mockito.times(0)).test1(Mockito.any(StringBuffer.class));

        testPublicVoidService1.test1(new StringBuffer().append(TestConstants.FLAG1));

        //执行一次后，执行次数为1
        Mockito.verify(testPublicVoidService1, Mockito.times(1)).test1(argCaptor1.capture());

        Assert.assertEquals(TestConstants.FLAG1, argCaptor1.getValue().toString());

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
