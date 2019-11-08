package test.testmock.spring.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestPublicVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.base.TestMockBase;

//执行真实方法
public class TestSpMPuVThenCallRealMethod extends TestMockBase {

    //对于实现类，支持Mockito.doCallRealMethod().when()，执行真实方法
    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        TestPublicVoidService1Impl testPublicVoidService1 = Mockito.mock(TestPublicVoidService1Impl.class);

        Mockito.doCallRealMethod().when(testPublicVoidService1).test1(Mockito.any(StringBuffer.class));

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.test1(stringBuffer);

        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());

        //真实方法已执行
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }

    //对于实现类，支持PowerMockito.when().thenCallRealMethod()，执行真实方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPublicVoidService1Impl.class, TestPublicVoidService1Impl.NAME_TEST1);

        TestPublicVoidService1Impl testPublicVoidService1 = Mockito.mock(TestPublicVoidService1Impl.class);

        PowerMockito.when(testPublicVoidService1, TestPublicVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenCallRealMethod();

        StringBuffer stringBuffer = new StringBuffer();

        testPublicVoidService1.test1(stringBuffer);

        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());

        //真实方法已执行
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPublicVoidService1Impl.class,
                TestPublicVoidService1Impl.NAME_TEST1));
    }
}
