package test.testmock.spring.spy.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassIsInstance;

//执行真实方法
public class TestSpSPuNVThenCallRealMethod extends TestSpringSpyPublicNonVoidBase {

    //对于接口的Spy对象，不支持Mockito.when().thenCallRealMethod()
    @Test
    public void test1() {

        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.spy(TestPublicNonVoidService1.class);

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenCallRealMethod();
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.when(testPublicNonVoidService1Spy.test1(TestConstants.FLAG1)).thenCallRealMethod();

        //Mockito.when执行了真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);
        //满足Stub条件，执行真实方法，返回数据应为原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法已执行2次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        str = testPublicNonVoidService1Spy.test1("");
        //不满足Stub条件，执行真实方法，返回数据应为原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法已执行3次
        Assert.assertEquals(3, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test3() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.doCallRealMethod().when(testPublicNonVoidService1Spy).test1(TestConstants.FLAG1);

        //Mockito.do...().when()不执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);
        //满足Stub条件，执行真实方法，返回数据应为原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法已执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        str = testPublicNonVoidService1Spy.test1("");
        //不满足Stub条件，执行真实方法，返回数据应为原始值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法已执行2次
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
