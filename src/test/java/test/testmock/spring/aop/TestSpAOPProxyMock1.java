package test.testmock.spring.aop;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.TestAOPService2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//将AOP代理对象替换为Mock对象
public class TestSpAOPProxyMock1 extends TestMockBase {

    @Autowired
    private TestAOPService2 testAOPService2;

    private static boolean inited = false;

    @Before
    public void init() {

        if (inited) {
            return;
        }

        inited = true;

        //经过AOP Aspect处理，不满足检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService2.test1("");
        Assert.assertEquals(TestConstants.MINUS, str);

        TestAOPService1 testAOPService1Mock = Mockito.mock(TestAOPService1.class);

        Mockito.when(testAOPService1Mock.testAround(TestConstants.FLAG3)).thenReturn(TestConstants.MOCKED);

        Whitebox.setInternalState(testAOPService2, testAOPService1Mock);
    }

    @Test
    public void test1() {

        //AOP代理对象被替换为Mock对象，不执行Aspect的方法，返回Mock对象被Stub方法返回值
        String str = testAOPService2.test1(TestConstants.FLAG3);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {

        //AOP代理对象被替换为Mock对象，不执行Aspect的方法，不满足Sutb参数条件，返回null
        String str = testAOPService2.test1("");
        Assert.assertNull(str);
    }
}
