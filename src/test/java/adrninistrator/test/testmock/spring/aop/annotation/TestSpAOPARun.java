package adrninistrator.test.testmock.spring.aop.annotation;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.spring.aop.method.TestSpAOPMProxyInfo1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPAnnotationService1;
import com.adrninistrator.service.impl.TestAOPAnnotationService1Impl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// 执行被AOP处理的方法，使用注解形式指定AOP处理
public class TestSpAOPARun extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpAOPMProxyInfo1.class);

    @Autowired
    private TestAOPAnnotationService1 testAOPAnnotationService1;

    @Test
    public void test() {
        // AOP代理对象的Class对象不等于原始类的Class对象
        assertNotEquals(TestAOPAnnotationService1Impl.class, testAOPAnnotationService1.getClass());
        logger.info("aop class name: {}", testAOPAnnotationService1.getClass().getName());

        if (testAOPAnnotationService1.getClass().getName().contains(TestAOPAnnotationService1Impl.class.getSimpleName())) {
            // AOP代理对象类名中包含原始类名，说明使用CGLIB代理
            logger.info("使用CGLIB代理");
        } else {
            // AOP代理对象类名中不包含原始类名，说明使用JDK动态代理
            logger.info("使用JDK动态代理");
        }

        String str = testAOPAnnotationService1.testAround("");
        assertEquals(TestConstants.NOT_MOCKED + TestConstants.MINUS, str);
    }
}