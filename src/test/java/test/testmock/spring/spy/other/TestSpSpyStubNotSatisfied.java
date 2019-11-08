package test.testmock.spring.spy.other;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.testmock.spring.spy.public1.non_void.TestSpringSpyPublicNonVoidBase;

//被Stub方法条件不满足的返回值
public class TestSpSpyStubNotSatisfied extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test() {

        Mockito.doReturn(TestConstants.MOCKED).when(testPublicNonVoidService1Spy).test3(TestConstants.FLAG1);

        String str = testPublicNonVoidService1Spy.test3(TestConstants.FLAG1);
        //被Stub的方法，参数满足条件时，返回指定的值
        Assert.assertEquals(TestConstants.MOCKED, str);

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));

        str = testPublicNonVoidService1Spy.test3("");
        //被Stub的方法，参数不满足条件时，返回真实方法返回值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
