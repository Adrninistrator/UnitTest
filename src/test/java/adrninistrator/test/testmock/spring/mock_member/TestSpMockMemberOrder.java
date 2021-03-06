package adrninistrator.test.testmock.spring.mock_member;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 变量替换与Stub的顺序
public class TestSpMockMemberOrder extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Test
    public void test1() {
        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class);

        Whitebox.setInternalState(testServiceB1, testServiceA1);

        // 将testServiceB1中的TestServiceA1对象替换为被Mock的对象
        Mockito.when(testServiceA1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        // Whitebox.setInternalState与Mockito.when的执行顺序对结果没有影响
        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class);

        // 将testServiceB1中的TestServiceA1对象替换为被Mock的对象
        Mockito.when(testServiceA1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        Whitebox.setInternalState(testServiceB1, testServiceA1);

        // Whitebox.setInternalState与Mockito.when的执行顺序对结果没有影响
        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
