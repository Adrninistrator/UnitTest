package test.testmock.spring.aop;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.TestService2;
import com.test.service.impl.TestAOPService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.powermock.reflect.exceptions.FieldNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.common.TestMatcherExpClassEquals;
import test.testmock.base.TestMockBase;

//查看AOP代理对象信息
public class TestSpAOPProxyInfo1 extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpAOPProxyInfo1.class);

    @Autowired
    private TestAOPService1 testAOPService1;

    @Before
    public void init() {

        //AOP代理对象的类名不等于原始类名
        Assert.assertNotEquals(TestAOPService1Impl.class.getName(), testAOPService1.getClass().getName());
        logger.info("aop class name: {}", testAOPService1.getClass().getName());

        if (testAOPService1.getClass().getName().contains(TestAOPService1Impl.class.getSimpleName())) {
            //AOP代理对象类名中包含原始类名，说明使用CGLIB代理

            //获取代理对象中的成员变量，为空
            TestService2 testService2 = Whitebox.getInternalState(testAOPService1, TestService2.class);
            Assert.assertNull(testService2);
        } else {
            //AOP代理对象类名中不包含原始类名，说明使用JDK动态代理

            //获取代理对象中的成员变量，出现异常
            expectedException.expect(new TestMatcherExpClassEquals(FieldNotFoundException.class));

            Whitebox.getInternalState(testAOPService1, TestService2.class);
        }
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        //经过AOP Aspect处理，不满足检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService1.testAround("");
        Assert.assertEquals(TestConstants.MINUS, str);

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND));
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        //经过AOP Aspect处理，满足检查条件，执行原始对象方法
        String str = testAOPService1.testAround(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND));
    }
}
