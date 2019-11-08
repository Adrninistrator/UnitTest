package test.testmock.spring.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestCommonUtil;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

//使用Answer实现回调
public class TestSpMPuVThenAnswer extends TestMockBase {

    @Test
    public void test1() {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doAnswer(invocation -> {

            StringBuffer arg = TestCommonUtil.getMockArg(invocation, 0, StringBuffer.class);

            Assert.assertEquals(TestConstants.FLAG1, arg.toString());

            arg.setLength(0);
            arg.append(TestConstants.MOCKED);

            return null;
        }).when(testPublicVoidService1).test1(Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TestConstants.FLAG1);

        testPublicVoidService1.test1(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        //真实方法未执行
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    @Test
    public void test2() {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        PowerMockito.doAnswer(invocation -> {

            invocation.callRealMethod();

            return null;
        }).when(testPublicVoidService1).test1(Mockito.any(StringBuffer.class));

        //不支持对接口的Mock对象执行真实方法，应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        testPublicVoidService1.test1(new StringBuffer());
    }

    @Test
    public void test3() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        TestPublicVoidService1Impl testPublicVoidService1 = Mockito.mock(TestPublicVoidService1Impl.class);

        PowerMockito.doAnswer(invocation -> {

            invocation.callRealMethod();

            return null;
        }).when(testPublicVoidService1).test1(Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.test1(stringBuffer);

        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());

        //真实方法执行1次
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
