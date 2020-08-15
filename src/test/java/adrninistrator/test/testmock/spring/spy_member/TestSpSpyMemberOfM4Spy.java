package adrninistrator.test.testmock.spring.spy_member;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

public class TestSpSpyMemberOfM4Spy {

    public static void spy1(TestServiceB1 testServiceB1, TestServiceA1 testServiceA1) {
        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());

        Whitebox.setInternalState(testServiceB1, testServiceA1Spy);
    }

    public static void spy2(TestServiceB1 testServiceB1, TestServiceA1 testServiceA1) {
        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test3(Mockito.anyString());

        Whitebox.setInternalState(testServiceB1, testServiceA1Spy);
    }

    private TestSpSpyMemberOfM4Spy() {
        throw new IllegalStateException("illegal");
    }
}
