package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.TestAOPService2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.assertEquals;

public class TestSpAOPMProxySpy1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Autowired
    private TestAOPService2 testAOPService2;

    private static boolean inited = false;

    @Before
    public void init() {
        if (inited) {
            return;
        }

        inited = true;

        // 经过AOP处理，执行方法时的参数不满足Aspect中的检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService2.test1("");
        assertEquals(TestConstants.MINUS, str);

        // 使用AopTestUtils.getTargetObject获取原始对象
        TestAOPService1 testAOPService1Raw = AopTestUtils.getTargetObject(testAOPService1);

        TestAOPService1 testAOPService1Spy = Mockito.spy(testAOPService1Raw);

        Mockito.doReturn(TestConstants.FLAG1).when(testAOPService1Spy).testAround(TestConstants.FLAG1);

        Whitebox.setInternalState(testAOPService2, testAOPService1Spy);
    }

    @Test
    public void test1() {
        // AOP代理对象被替换为Mock对象，不执行Aspect的方法，返回Spy对象被Stub方法返回值
        String str = testAOPService2.test1(TestConstants.FLAG1);
        assertEquals(TestConstants.FLAG1, str);
    }

    @Test
    public void test2() {
        // AOP代理对象被替换为Mock对象，不执行Aspect的方法，不满足Sutb参数条件，返回原始值
        String str = testAOPService2.test1(TestConstants.FLAG2);
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
