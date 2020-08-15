package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.TestService2;
import com.adrninistrator.service.impl.TestAOPService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.powermock.reflect.exceptions.FieldNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

// 查看AOP代理对象信息
public class TestSpAOPMProxyInfo1 extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpAOPMProxyInfo1.class);

    @Autowired
    private TestAOPService1 testAOPService1;

    @Before
    public void init() {
        // AOP代理对象的Class对象不等于原始类的Class对象
        assertNotEquals(TestAOPService1Impl.class, testAOPService1.getClass());
        logger.info("aop class name: {}", testAOPService1.getClass().getName());

        if (testAOPService1.getClass().getName().contains(TestAOPService1Impl.class.getSimpleName())) {
            // AOP代理对象类名中包含原始类名，说明使用CGLIB代理

            // 获取代理对象中的成员变量，为空
            TestService2 testService2 = Whitebox.getInternalState(testAOPService1, TestService2.class);
            assertNull(testService2);
        } else {
            // AOP代理对象类名中不包含原始类名，说明使用JDK动态代理

            // 获取代理对象中的成员变量，出现异常
            assertThrows(FieldNotFoundException.class, () ->
                    Whitebox.getInternalState(testAOPService1, TestService2.class)
            );
        }
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        // 经过AOP处理，执行方法时的参数不满足Aspect中的检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService1.testAround("");
        assertEquals(TestConstants.MINUS, str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        // 经过AOP处理，执行方法时的参数满足Aspect中的检查条件，执行原始对象方法
        String str = testAOPService1.testAround(TestConstants.FLAG1);
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND));
    }
}
