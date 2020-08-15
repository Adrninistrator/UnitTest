package adrninistrator.test.testmock.spring.mock_member;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

public class TestSpMockMemberOfM4Mock {

    public static void mock1(TestServiceB1 testServiceB1) {
        TestServiceA1 testServiceA1Mock = Mockito.mock(TestServiceA1.class);

        Mockito.when(testServiceA1Mock.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        Whitebox.setInternalState(testServiceB1, testServiceA1Mock);
    }

    public static void mock2(TestServiceB1 testServiceB1) {
        TestServiceA1 testServiceA1Mock = Mockito.mock(TestServiceA1.class);

        Mockito.when(testServiceA1Mock.test3(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        Whitebox.setInternalState(testServiceB1, testServiceA1Mock);
    }

    private TestSpMockMemberOfM4Mock() {
        throw new IllegalStateException("illegal");
    }
}
