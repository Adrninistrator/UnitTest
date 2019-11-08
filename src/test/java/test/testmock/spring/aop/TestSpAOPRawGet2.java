package test.testmock.spring.aop;

import com.test.service.TestAOPService1;
import com.test.service.impl.TestAOPService1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;
import test.common.TestCommonUtil;
import test.testmock.base.TestMockBase;

//获取原始对象
//使用AopTestUtils.getTargetObject()方法
public class TestSpAOPRawGet2 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Test
    public void test() throws Exception {

        if (!AopUtils.isAopProxy(testAOPService1) || !(testAOPService1 instanceof Advised)) {
            Assert.fail("illegal");
        }

        Advised advised = (Advised) testAOPService1;

        TestAOPService1 testAOPService1Raw1 = (TestAOPService1) advised.getTargetSource().getTarget();

        TestAOPService1 testAOPService1Raw2 = AopTestUtils.getTargetObject(testAOPService1);

        Assert.assertEquals(TestAOPService1Impl.class.getName(), testAOPService1Raw1.getClass().getName());
        Assert.assertEquals(TestAOPService1Impl.class.getName(), testAOPService1Raw2.getClass().getName());

        TestCommonUtil.compareObj(testAOPService1Raw1, testAOPService1Raw2, true);
    }
}
