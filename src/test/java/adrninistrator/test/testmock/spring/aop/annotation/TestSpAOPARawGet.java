package adrninistrator.test.testmock.spring.aop.annotation;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestAOPAnnotationService1;
import com.adrninistrator.service.impl.TestAOPAnnotationService1Impl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.assertEquals;

// 执行被AOP处理的原始对象，使用注解形式指定AOP处理
public class TestSpAOPARawGet extends TestMockBase {

    @Autowired
    private TestAOPAnnotationService1 testAOPAnnotationService1;

    @Test
    public void test() {
        // 使用AopTestUtils.getTargetObject获取原始对象
        TestAOPAnnotationService1 testAOPAnnotationService1Raw = AopTestUtils.getTargetObject(testAOPAnnotationService1);

        assertEquals(TestAOPAnnotationService1Impl.class, testAOPAnnotationService1Raw.getClass());
    }
}