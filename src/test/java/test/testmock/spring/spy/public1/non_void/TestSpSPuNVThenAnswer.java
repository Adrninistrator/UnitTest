package test.testmock.spring.spy.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestCommonUtil;

//使用Answer实现回调
public class TestSpSPuNVThenAnswer extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.when(testPublicNonVoidService1Spy.test1(TestConstants.FLAG1)).thenAnswer(invocation -> {

            String arg = TestCommonUtil.getMockArg(invocation, 0, String.class);

            Assert.assertEquals(TestConstants.FLAG1, arg);

            return TestConstants.MOCKED;
        });

        //Mockito.when执行了真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);

        //满足条件，返回值为被Stub的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1);

        Mockito.doAnswer(invocation -> {

            String arg = TestCommonUtil.getMockArg(invocation, 0, String.class);

            if (TestConstants.FLAG1.equals(arg)) {
                return TestConstants.MOCKED;
            } else {
                return invocation.callRealMethod();
            }
        }).when(testPublicNonVoidService1Spy).test1(TestConstants.FLAG1);

        //Mockito.do...().when()不执行真实方法
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        String str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG1);

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));

        //参数为TestConstants.FLAG1，返回值为被Mock的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        str = testPublicNonVoidService1Spy.test1(TestConstants.FLAG2);

        //参数非TestConstants.FLAG1，返回值为真实方法返回值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST1));
    }
}
