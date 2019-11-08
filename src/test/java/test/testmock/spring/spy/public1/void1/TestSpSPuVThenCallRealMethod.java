package test.testmock.spring.spy.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

//执行真实方法
public class TestSpSPuVThenCallRealMethod extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doCallRealMethod().when(testPublicVoidService1Spy).test1(Mockito.any(StringBuffer.class));

        //Mockito.doCallRealMethod()未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1Spy.test1(stringBuffer);

        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());

        //真实方法执行了1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
