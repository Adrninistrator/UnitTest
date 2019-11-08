package test.testmock.spring.aop;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.TestService2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;
import test.testmock.base.TestMockBase;

//替换AOP原始对象中的变量为Spy对象
public class TestSpAOPRawSpyMem1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Autowired
    private TestAOPService1 testAOPService2;

    @Autowired
    private TestService2 testService2;

    @Before
    public void init() {

        String str = testAOPService2.test2("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }

    @Test
    public void test() {

        TestService2 testService2Spy = Mockito.spy(testService2);
        Mockito.doReturn(TestConstants.MOCKED).when(testService2Spy).test1(TestConstants.FLAG3);

        TestAOPService1 testAOPService1Raw = AopTestUtils.getTargetObject(testAOPService1);

        Whitebox.setInternalState(testAOPService1Raw, testService2Spy);

        //直接调用AOP代理对象的方法，会调用成员变量被替换的Spy对象对应的方法
        String str = testAOPService1.test2(TestConstants.FLAG3);
        Assert.assertEquals(TestConstants.MOCKED, str);

        //间接调用AOP代理对象的方法，会调用成员变量被替换的Spy对象对应的方法
        str = testAOPService2.test2(TestConstants.FLAG3);
        Assert.assertEquals(TestConstants.MOCKED, str);

        //间接调用AOP代理对象的方法，会调用成员变量被替换的Spy对象对应的方法，不满足Stub条件，执行原始方法
        str = testAOPService2.test2("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
