package test.testmock.spring.mock.public1.void1;

import com.test.service.TestPublicVoidService1;
import com.test.service.impl.TestPublicVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.base.TestMockBase;

//执行真实方法
public class TestSpMPuVThenCallRealMethodInterface extends TestMockBase {

    //对于接口的Mock对象，不支持Mockito.doCallRealMethod().when()
    @Test
    public void test1() throws Exception {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        Mockito.doCallRealMethod().when(testPublicVoidService1).test1(Mockito.any(StringBuffer.class));
    }

    //对于接口的Mock对象，不支持PowerMockito.when().thenCallRealMethod()
    @Test
    public void test2() throws Exception {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        //应出现指定异常
        expectedException.expect(new TestMatcherExpClassIsInstance(Exception.class));

        PowerMockito.when(testPublicVoidService1, TestPublicVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenCallRealMethod();
    }
}
