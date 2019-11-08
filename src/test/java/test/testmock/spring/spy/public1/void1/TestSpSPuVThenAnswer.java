package test.testmock.spring.spy.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestCommonUtil;

//使用Answer实现回调
public class TestSpSPuVThenAnswer extends TestSpringSpyPublicVoidBase {

    @Test
    public void test() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        Mockito.doAnswer(invocation -> {

            StringBuffer arg = TestCommonUtil.getMockArg(invocation, 0, StringBuffer.class);

            if (TestConstants.FLAG1.equals(arg.toString())) {
                arg.setLength(0);
                arg.append(TestConstants.MOCKED);

                return null;
            } else {
                invocation.callRealMethod();

                return null;
            }
        }).when(testPublicVoidService1Spy).test1(Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TestConstants.FLAG1);

        testPublicVoidService1Spy.test1(stringBuffer);

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));

        //参数为TestConstants.FLAG1，执行Stub的操作
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG2);

        testPublicVoidService1Spy.test1(stringBuffer);

        //参数非TestConstants.FLAG1，参数值为真实方法设置的值
        Assert.assertEquals(TestConstants.FLAG2 + TestConstants.NOT_MOCKED, stringBuffer.toString());

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
