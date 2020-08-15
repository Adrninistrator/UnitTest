package adrninistrator.test.testmock.spring.mock.other;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

// 同一个类的多个Mock对象
public class TestSpMockMulti extends TestMockBase {

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock1;

    @Mock
    private TestPublicNonVoidService1 testPublicNonVoidService1Mock2;

    @Test
    public void test() {
        // 对同一个对象使用@Mock生成两个Mock对象，相互独立
        assertNotSame(testPublicNonVoidService1Mock1, testPublicNonVoidService1Mock2);

        Mockito.when(testPublicNonVoidService1Mock1.test1(Mockito.anyString())).thenReturn(TestConstants.FLAG1);

        Mockito.when(testPublicNonVoidService1Mock2.test1(Mockito.anyString())).thenReturn(TestConstants.FLAG2);

        String str = testPublicNonVoidService1Mock1.test1("");
        assertEquals(TestConstants.FLAG1, str);

        str = testPublicNonVoidService1Mock2.test1("");
        assertEquals(TestConstants.FLAG2, str);
    }
}
