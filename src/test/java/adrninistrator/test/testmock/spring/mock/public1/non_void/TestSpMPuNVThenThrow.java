package adrninistrator.test.testmock.spring.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
public class TestSpMPuNVThenThrow extends TestMockBase {

    @Test
    public void test() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        Mockito.when(testPublicNonVoidService1.test1(TestConstants.FLAG1)).thenThrow(new RuntimeException
                (TestConstants.MOCKED));

        // 满足Stub条件，抛出异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicNonVoidService1.test1(TestConstants.FLAG1)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
