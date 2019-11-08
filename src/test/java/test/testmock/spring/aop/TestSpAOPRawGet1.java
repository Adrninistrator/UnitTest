package test.testmock.spring.aop;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.impl.TestAOPService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//获取原始对象
//使用Advised.getTargetSource().getTarget()方法
public class TestSpAOPRawGet1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    private TestAOPService1 testAOPService1Raw;

    @Before
    public void init() throws Exception {

        if (!AopUtils.isAopProxy(testAOPService1) || !(testAOPService1 instanceof Advised)) {
            Assert.fail("illegal");
        }

        Advised advised = (Advised) testAOPService1;

        testAOPService1Raw = (TestAOPService1) advised.getTargetSource().getTarget();

        Assert.assertEquals(TestAOPService1Impl.class.getName(), testAOPService1Raw.getClass().getName());
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        String str = testAOPService1Raw.testAround("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        String str = testAOPService1Raw.testAround(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
