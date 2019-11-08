package test.testmock.spring.aop;

import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.TestAOPService2;
import com.test.service.impl.TestAOPService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;
import test.testmock.base.TestMockBase;

//将AOP代理对象替换为原始对象
public class TestSpAOPRawGetUse1 extends TestMockBase {

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

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        //经过AOP Aspect处理，不满足检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService2.test1("");
        Assert.assertEquals(TestConstants.MINUS, str);

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));

        TestAOPService1 testAOPService1Raw = AopTestUtils.getTargetObject(testAOPService1);

        Whitebox.setInternalState(testAOPService2, testAOPService1Raw);
    }

    @Test
    public void test1() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        //AOP代理对象被替换为原始对象，不执行Aspect的方法，返回原始对象返回值
        String str = testAOPService2.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }

    @Test
    public void test2() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        //AOP代理对象被替换为原始对象，不执行Aspect的方法，返回原始对象返回值
        String str = testAOPService2.test1(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
