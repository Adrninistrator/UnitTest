package adrninistrator.test.testmock.spring.mock_member;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.TestServiceC1;
import com.adrninistrator.service.TestServiceC2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

// Spring Bean单例与变量替换
public class TestSpMockMemberOfM2 extends TestMockBase {

    @Autowired
    private TestServiceC1 testServiceC1;

    @Autowired
    private TestServiceC2 testServiceC2;

    @Before
    public void init() {
        String str = testServiceC1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {
        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class);

        Mockito.when(testServiceA1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        // 获取testServiceC1中的TestServiceB1对象
        TestServiceB1 testServiceB1InC1 = Whitebox.getInternalState(testServiceC1, TestServiceB1.class);

        // 将testServiceB1InC1中的TestServiceA1对象替换为被Mock的对象
        Whitebox.setInternalState(testServiceB1InC1, testServiceA1);

        String str = testServiceC1.test1("");
        assertEquals(TestConstants.MOCKED, str);

        // 调用testServiceC2.test1，返回结果也是被Stub的数据
        str = testServiceC2.test1("");
        assertEquals(TestConstants.MOCKED, str);

        TestServiceB1 testServiceB1InC2 = Whitebox.getInternalState(testServiceC2, TestServiceB1.class);

        // testServiceC1与testServiceC2中的TestServiceB1对象实例为同一个
        assertSame(testServiceB1InC1, testServiceB1InC2);
    }
}
