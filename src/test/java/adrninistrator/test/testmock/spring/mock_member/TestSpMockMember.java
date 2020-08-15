package adrninistrator.test.testmock.spring.mock_member;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 替换成员变量为Mock对象
public class TestSpMockMember extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Before
    public void init() {
        String str = testServiceB1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {
        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class);

        Mockito.when(testServiceA1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        // 将testServiceB1中的TestServiceA1对象替换为被Mock的对象
        Whitebox.setInternalState(testServiceB1, testServiceA1);

        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
