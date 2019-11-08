package test.testmock.spring.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.service.impl.TestPublicVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//抛出异常
public class TestSpMPuVThenThrow extends TestMockBase {

    @Test
    public void test1() throws Exception {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1).test1(Mockito.any
                (StringBuffer.class));

        //满足Stub条件，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicVoidService1.test1(new StringBuffer());
    }

    @Test
    public void test2() throws Exception {

        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        PowerMockito.when(testPublicVoidService1, TestPublicVoidService1Impl.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        //满足Stub条件，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicVoidService1.test1(new StringBuffer());
    }
}
