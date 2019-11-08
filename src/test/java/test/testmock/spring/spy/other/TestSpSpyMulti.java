package test.testmock.spring.spy.other;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockBase;

//同一个类的多个Spy对象
public class TestSpSpyMulti extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    private TestPublicNonVoidService1 testPublicNonVoidService1Spy1;

    private TestPublicNonVoidService1 testPublicNonVoidService1Spy2;

    @Before
    public void init() {

        testPublicNonVoidService1Spy1 = Mockito.spy(testPublicNonVoidService1);

        testPublicNonVoidService1Spy2 = Mockito.spy(testPublicNonVoidService1);
    }

    @Test
    public void test() {

        //对同一个对象使用Mockito.spy生成两个Spy对象，相互独立
        TestCommonUtil.compareObj(testPublicNonVoidService1Spy1, testPublicNonVoidService1Spy2, false);

        Mockito.doReturn(TestConstants.FLAG1).when(testPublicNonVoidService1Spy1).test2(Mockito.anyString());

        Mockito.doReturn(TestConstants.FLAG2).when(testPublicNonVoidService1Spy2).test2(Mockito.anyString());

        String str = testPublicNonVoidService1Spy1.test2("");
        Assert.assertEquals(TestConstants.FLAG1, str);

        str = testPublicNonVoidService1Spy2.test2("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
