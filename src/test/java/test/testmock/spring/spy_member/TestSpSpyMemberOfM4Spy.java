package test.testmock.spring.spy_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import test.common.TestCommonUtil;

public class TestSpSpyMemberOfM4Spy {

    public static void mock1(TestServiceB1 testServiceB1, TestServiceA1 testServiceA1) {

        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());

        Whitebox.setInternalState(testServiceB1, testServiceA1Spy);
    }

    public static void mock2(TestServiceB1 testServiceB1, TestServiceA1 testServiceA1) {

        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test3(Mockito.anyString());

        Whitebox.setInternalState(testServiceB1, testServiceA1Spy);
    }

    private TestSpSpyMemberOfM4Spy() {
        throw new IllegalStateException("illegal");
    }
}
