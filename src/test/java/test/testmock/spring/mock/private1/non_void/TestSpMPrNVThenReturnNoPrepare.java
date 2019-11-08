package test.testmock.spring.mock.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestPrivateNonVoidService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import test.testmock.base.TestMockBase;

//Stub @Component组件私有非void方法，不使用@PrepareForTest注解时Stub失败
public class TestSpMPrNVThenReturnNoPrepare extends TestMockBase {

    //PowerMockito.do...().when()支持私有方法，PowerMockito.mock返回的对象Stub失败
    /*
        以下方法执行结束时会出现失败，提示“Test mechanism.classMethod FAILED”
        org.mockito.exceptions.misusing.InvalidUseOfMatchersException:
        Misplaced or misused argument matcher detected here:
     */
    @Test
    public void test() throws Exception {

        TestPrivateNonVoidService1Impl testPrivateNonVoidService1 = PowerMockito.mock(TestPrivateNonVoidService1Impl
                .class);

        PowerMockito.doReturn(TestConstants.MOCKED).when(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl
                .NAME_TEST1, Mockito.anyString());

        String str = Whitebox.invokeMethod(testPrivateNonVoidService1, TestPrivateNonVoidService1Impl.NAME_TEST1, "");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
