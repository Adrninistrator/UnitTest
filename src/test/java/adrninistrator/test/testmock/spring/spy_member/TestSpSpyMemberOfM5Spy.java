package adrninistrator.test.testmock.spring.spy_member;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

public class TestSpSpyMemberOfM5Spy {

    public static void spy1(TestServiceB1 testServiceB1) {
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        if (testServiceA1InB1.getClass() == TestServiceA1Impl.class) {
            TestServiceA1 testServiceA1Mock = Mockito.mock(TestServiceA1.class);

            doSpy1(testServiceA1Mock);

            Whitebox.setInternalState(testServiceB1, testServiceA1Mock);
        } else {
            doSpy1(testServiceA1InB1);
        }
    }

    private static void doSpy1(TestServiceA1 testServiceA1) {
        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1).test1(Mockito.anyString());
    }

    public static void spy2(TestServiceB1 testServiceB1) {
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        if (testServiceA1InB1.getClass() == TestServiceA1Impl.class) {
            TestServiceA1 testServiceA1Mock = Mockito.mock(TestServiceA1.class);

            doSpy2(testServiceA1Mock);

            Whitebox.setInternalState(testServiceB1, testServiceA1Mock);
        } else {
            doSpy2(testServiceA1InB1);
        }
    }

    private static void doSpy2(TestServiceA1 testServiceA1) {
        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1).test3(Mockito.anyString());
    }

    private TestSpSpyMemberOfM5Spy() {
        throw new IllegalStateException("illegal");
    }
}
