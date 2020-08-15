package adrninistrator.test.testmock.spring.spy_member;

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
import static org.junit.Assert.assertSame;

// 替换成员变量为Mock对象
public class TestSpSpyMember extends TestMockBase {

    @Autowired
    private TestServiceA1 testServiceA1;

    @Autowired
    private TestServiceB1 testServiceB1;

    @Before
    public void init() {
        String str = testServiceB1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        // 当前类与testServiceB1中注入的TestServiceA1类的对象为同一个实例
        assertSame(testServiceA1, testServiceA1InB1);

        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());

        // 将testServiceB1中的TestServiceA1对象替换为被Spy的对象
        Whitebox.setInternalState(testServiceB1, testServiceA1Spy);

        String str = testServiceB1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
