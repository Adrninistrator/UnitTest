package test.testmock.spring.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

//Stub @Component组件私有非void方法，不支持使用Mockito.mock()返回的Mock对象
public class TestSpMPrNVThenReturnMockito extends TestMockBase {

    //Mockito.mock()返回的Mock对象，使用PowerMockito.when()方法时会出现异常
    @Test
    public void test1() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = Mockito.mock(TestPrivateNonVoidService1Impl.class);

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        PowerMockito.when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, Mockito
                .anyString()).thenReturn(TestConstants.MOCKED);
    }

    //Mockito.mock()返回的Mock对象，使用PowerMockito.do...().when()方法Stub失败
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestPrivateNonVoidService1Impl.class, TestPrivateNonVoidService1Impl
                .NAME_TEST1);

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = Mockito.mock(TestPrivateNonVoidService1Impl.class);

        PowerMockito.doReturn(TestConstants.MOCKED).when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl
                .NAME_TEST1, Mockito.anyString());

        //PowerMockito.doReturn执行了真实方法
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        //Whitebox.invokeMethod执行了真实方法
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestPrivateNonVoidService1Impl.class,
                TestPrivateNonVoidService1Impl.NAME_TEST1));

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
