package test.testmock.spring.mock.delegatesto;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.impl.TestServiceA1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

//委托方法调用，对方法进行Stub，使用Mockito.when()
public class TestSpMockDelegatesToStub1 extends TestSpMockDelegatesToStubBase {

    @Before
    public void init() {

        TestCallTimesUtil.clearCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl.NAME_TEST1);
        TestCallTimesUtil.clearCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl.NAME_TEST3);

        testServiceA1Delegate = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(new
                TestServiceA1Delegate()));

        Mockito.when(testServiceA1Delegate.test1(Mockito.anyString())).thenReturn(TestConstants.FLAG1);
        Mockito.when(testServiceA1Delegate.test3(Mockito.anyString())).thenReturn(TestConstants.FLAG3);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl
                .NAME_TEST1));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl
                .NAME_TEST3));
    }
}
