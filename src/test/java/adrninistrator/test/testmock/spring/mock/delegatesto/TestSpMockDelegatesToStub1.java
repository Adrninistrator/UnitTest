package adrninistrator.test.testmock.spring.mock.delegatesto;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 委托方法调用，对方法进行Stub，使用Mockito.when()
public class TestSpMockDelegatesToStub1 extends TestSpMockDelegatesToStubBase {

    @Before
    public void init() {
        TestCallTimesUtil.clearCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl.NAME_TEST1);
        TestCallTimesUtil.clearCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl.NAME_TEST3);

        testServiceA1Delegate = Mockito.mock(TestServiceA1.class, AdditionalAnswers.delegatesTo(new
                TestServiceA1Delegate()));

        // 对test1、test3方法进行Stub
        Mockito.when(testServiceA1Delegate.test1(Mockito.anyString())).thenReturn(TestConstants.FLAG1);
        Mockito.when(testServiceA1Delegate.test3(Mockito.anyString())).thenReturn(TestConstants.FLAG3);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl
                .NAME_TEST1));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestServiceA1Delegate.class, TestServiceA1Impl
                .NAME_TEST3));
    }
}
