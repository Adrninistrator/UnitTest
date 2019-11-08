package test.testmock.spring.spy.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

//修改返回值
public class TestSpSPuNVThenReturn extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.when(testPublicNonVoidService1Spy.test1(TestConstants.FLAG1)).thenReturn(TestConstants.MOCKED);

        //Mockito.when执行了真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);
        //满足条件，返回值为被Stub的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        //真实方法执行了1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        str = testPublicNonVoidService1Spy.test1("");
        //不满足Stub条件，执行真实方法，返回原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行了2次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1Spy).test1(TestConstants.FLAG1);

        //Mockito.doReturn未执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);
        //满足条件，返回值为被Stub的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        //真实方法执行了0次
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        str = testPublicNonVoidService1Spy.test1("");
        //不满足Stub条件，执行真实方法，返回原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行了1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
