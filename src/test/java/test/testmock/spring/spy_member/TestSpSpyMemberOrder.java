package test.testmock.spring.spy_member;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//变量替换与Stub的顺序
public class TestSpSpyMemberOrder extends TestMockBase {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Test
    public void test() {

        TestServiceA1 testServiceA1InB1 = Whitebox.getInternalState(testServiceB1, TestServiceA1.class);

        TestServiceA1 testServiceA1Spy = Mockito.spy(testServiceA1InB1);

        //将testServiceB1中的TestServiceA1对象替换为被Spy的对象
        Whitebox.setInternalState(testServiceB1, testServiceA1Spy);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(Mockito.anyString());

        //Whitebox.setInternalState与Mockito.when的执行顺序对结果没有影响
        String str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
