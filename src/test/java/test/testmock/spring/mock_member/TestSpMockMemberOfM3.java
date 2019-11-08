package test.testmock.spring.mock_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceB1;
import com.test.service.TestServiceB1;
import com.test.service.TestServiceC1;
import com.test.service.TestServiceC2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//将多个类引用的实例替换为独立的Mock对象
public class TestSpMockMemberOfM3 extends TestMockBase {

    @Autowired
    private TestServiceC1 testServiceC1;

    @Autowired
    private TestServiceC2 testServiceC2;

    @Test
    public void test() {

        TestServiceB1 testServiceB1InC1 = Mockito.mock(TestServiceB1.class);

        Mockito.when(testServiceB1InC1.test1(Mockito.anyString())).thenReturn(TestConstants.FLAG1);

        //将testServiceC1中的TestServiceB1对象替换为被Mock的对象
        Whitebox.setInternalState(testServiceC1, testServiceB1InC1);

        TestServiceB1 testServiceB1InC2 = Mockito.mock(TestServiceB1.class);

        Mockito.when(testServiceB1InC2.test1(Mockito.anyString())).thenReturn(TestConstants.FLAG2);

        //将testServiceC2中的TestServiceB1对象替换为被Mock的对象
        Whitebox.setInternalState(testServiceC2, testServiceB1InC2);

        String str = testServiceC1.test1("");
        Assert.assertEquals(TestConstants.FLAG1, str);

        str = testServiceC2.test1("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
