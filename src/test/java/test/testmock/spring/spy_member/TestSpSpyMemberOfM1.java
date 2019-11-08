package test.testmock.spring.spy_member;

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
public class TestSpSpyMemberOfM1 extends TestMockBase {

    @Autowired
    private TestServiceC1 testServiceC1;

    @Before
    public void init() {

        String str = testServiceC1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {

        TestServiceB1 testServiceB1InC1 = Whitebox.getInternalState(testServiceC1, TestServiceB1.class);
        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1InC1, TestServiceA1.class);

        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1InB1);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());

        //将testServiceB1中的TestServiceA1对象替换为被Spy的对象
        Whitebox.setInternalState(testServiceB1InC1, testServiceA1Spy);

        String str = testServiceC1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
