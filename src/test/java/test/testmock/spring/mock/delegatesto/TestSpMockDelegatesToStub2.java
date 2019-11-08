package test.testmock.spring.mock.delegatesto;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.impl.TestServiceA1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

//委托方法调用，对方法进行Stub，使用Mockito.do...().when()
public class TestSpMockDelegatesToStub2 extends TestSpMockDelegatesToStubBase {

    @Before
    public void init() {

        TestCallTimesUtil.clearCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl.NAME_TEST1);
        TestCallTimesUtil.clearCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl.NAME_TEST3);

        testServiceA1Delegate = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(new
                TestServiceA1Delegate()));

        Mockito.doReturn(TestConstants.FLAG1).when(testServiceA1Delegate).test1(Mockito.anyString());
        Mockito.doReturn(TestConstants.FLAG3).when(testServiceA1Delegate).test3(Mockito.anyString());

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl
                .NAME_TEST1));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl
                .NAME_TEST3));
    }
}
