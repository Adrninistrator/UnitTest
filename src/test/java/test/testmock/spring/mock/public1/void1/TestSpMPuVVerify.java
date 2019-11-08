package test.testmock.spring.mock.public1.void1;

import com.test.service.TestPublicVoidService1;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.testmock.base.TestMockBase;

//使用verify判断方法的执行次数
public class TestSpMPuVVerify extends TestMockBase {

    @Test
    public void test() {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        //初始，执行次数为0
        Mockito.verify(testPublicVoidService1, Mockito.times(0)).test1(Mockito.any(StringBuffer.class));

        testPublicVoidService1.test1(new StringBuffer());

        //执行一次后，执行次数为1
        Mockito.verify(testPublicVoidService1, Mockito.times(1)).test1(Mockito.any(StringBuffer.class));

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
