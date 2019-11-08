package test.testmock.spring.mock_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.impl.TestServiceA1Impl;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;

public class TestSpMockMemberOfM5Mock {

    public static void mock1(TestServiceB1 testServiceB1) {

        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        if (testServiceA1InB1.getClass() == TestServiceA1Impl.class) {

            TestServiceA1 testServiceA1Mock = Mockito.mock(TestServiceA1.class);

            doMock1(testServiceA1Mock);

            Whitebox.setInternalState(testServiceB1, testServiceA1Mock);
        } else {
            doMock1(testServiceA1InB1);
        }
    }

    private static void doMock1(TestServiceA1 testServiceA1) {

        Mockito.when(testServiceA1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);
    }

    public static void mock2(TestServiceB1 testServiceB1) {

        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        if (testServiceA1InB1.getClass() == TestServiceA1Impl.class) {

            TestServiceA1 testServiceA1Mock = Mockito.mock(TestServiceA1.class);

            doMock2(testServiceA1Mock);

            Whitebox.setInternalState(testServiceB1, testServiceA1Mock);
        } else {
            doMock2(testServiceA1InB1);
        }
    }

    private static void doMock2(TestServiceA1 testServiceA1) {

        Mockito.when(testServiceA1.test3(Mockito.anyString())).thenReturn(TestConstants.MOCKED);
    }

    private TestSpMockMemberOfM5Mock() {
        throw new IllegalStateException("illegal");
    }
}
