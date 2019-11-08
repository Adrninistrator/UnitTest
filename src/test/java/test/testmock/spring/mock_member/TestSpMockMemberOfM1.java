package test.testmock.spring.mock_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.TestServiceC1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//替换成员变量的成员变量为Mock对象
public class TestSpMockMemberOfM1 extends TestMockBase {

    @Autowired
    private TestServiceC1 testServiceC1;

    @Before
    public void init() {

        String str = testServiceC1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {

        TestServiceA1 testServiceA1 = Mockito.mock(TestServiceA1.class);

        Mockito.when(testServiceA1.test1(Mockito.anyString())).thenReturn(TestConstants.MOCKED);

        //获取testServiceC1中的TestServiceB1对象
        TestServiceB1 testServiceB1 = Whitebox.getInternalState(testServiceC1, TestServiceB1.class);

        //将testServiceB1中的TestServiceA1对象替换为被Mock的对象
        Whitebox.setInternalState(testServiceB1, testServiceA1);

        String str = testServiceC1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
