package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.impl.TestAOPService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// 获取原始对象
// 使用Advised.getTargetSource().getTarget()方法
public class TestSpAOPMRawGet1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    private TestAOPService1 testAOPService1Raw;

    @Before
    public void init() throws Exception {

        if (!AopUtils.isAopProxy(testAOPService1) || !(testAOPService1 instanceof Advised)) {
            fail("illegal");
        }

        Advised advised = (Advised) testAOPService1;

        testAOPService1Raw = (TestAOPService1) advised.getTargetSource().getTarget();

        assertEquals(TestAOPService1Impl.class, testAOPService1Raw.getClass());
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        String str = testAOPService1Raw.testAround("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        String str = testAOPService1Raw.testAround(TestConstants.FLAG1);
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
