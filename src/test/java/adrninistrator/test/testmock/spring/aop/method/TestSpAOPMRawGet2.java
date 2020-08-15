package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.impl.TestAOPService1Impl;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.*;

// 获取原始对象
// 使用AopTestUtils.getTargetObject()方法
public class TestSpAOPMRawGet2 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Test
    public void test() throws Exception {

        if (!AopUtils.isAopProxy(testAOPService1) || !(testAOPService1 instanceof Advised)) {
            fail("illegal");
        }

        Advised advised = (Advised) testAOPService1;

        TestAOPService1 testAOPService1Raw1 = (TestAOPService1) advised.getTargetSource().getTarget();

        // 使用AopTestUtils.getTargetObject获取原始对象
        TestAOPService1 testAOPService1Raw2 = AopTestUtils.getTargetObject(testAOPService1);

        assertEquals(TestAOPService1Impl.class, testAOPService1Raw1.getClass());
        assertEquals(TestAOPService1Impl.class, testAOPService1Raw2.getClass());

        assertSame(testAOPService1Raw1, testAOPService1Raw2);
    }
}
