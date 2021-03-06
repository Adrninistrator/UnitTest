package adrninistrator.test.testmock.spring.mock.public1.non_void;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

// 修改返回值，Stub同一个方法多次，每次执行不同的Stub操作
public class TestSpMPuNVThenReturnMulti extends TestMockBase {

    @Test
    public void test() {
        TestPublicNonVoidService1 testPublicNonVoidService1 = Mockito.mock(TestPublicNonVoidService1.class);

        // Stub对应方法，使其第一次返回TestConstants.FLAG1，第二次及之后返回TestConstants.FLAG2
        Mockito.doReturn(TestConstants.FLAG1).doReturn(TestConstants.FLAG2).when(testPublicNonVoidService1).test1
                (Mockito.anyString());

        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.FLAG1, str);

        str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.FLAG2, str);

        str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.FLAG2, str);
    }
}
