package test.testmock.spring.mock.private1.non_void;

import com.test.service.impl.TestPrivateNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

//使用verify判断方法的执行次数，使用Mockito.verify时会出现问题
public class TestSpMPrNVVerifyMockito extends TestMockBase {

    //Mockito.verify执行一次正常，执行一次以上出现异常
    @Test
    public void test() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = Mockito.mock(TestPrivateNonVoidService1Impl.class);

        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //Whitebox.invokeMethod执行了真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        Mockito.verify(testPrivateNonVoidService1, Mockito.times(1));
        Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //Whitebox.invokeMethod执行了真实方法
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.verify(testPrivateNonVoidService1, Mockito.times(1));
    }
}
