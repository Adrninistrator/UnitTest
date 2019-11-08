package test.testmock.spring.spy.other;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import test.testmock.spring.spy.public1.non_void.TestSpringSpyPublicNonVoidBase;

//未Stub的方法的返回值
public class TestSpSpyUnstubbedMethod extends TestSpringSpyPublicNonVoidBase {

    @Test
    public void test() {

        String str = testPublicNonVoidService1Spy.test3("");
        //未Stub的方法，返回真实方法返回值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicNonVoidService1Impl.class,
                TestPublicNonVoidService1Impl.NAME_TEST3));
    }
}
