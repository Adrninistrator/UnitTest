package test.testmock.spring.mock.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Mockito;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//抛出异常
public class TestSpMPuNVThenThrow extends TestMockBase {

    @Test
    public void test() {

        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenThrow(new RuntimeException
                (TestConstants.MOCKED));

        //满足Stub条件，抛出异常
        expectedException.expect(new TestMatcherExpClassEquals(RuntimeException.class));
        expectedException.expectMessage(TestConstants.MOCKED);

        testPublicNonVoidService1.test1(TestConstants.FLAG1);
    }
}
