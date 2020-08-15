package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.TestAOPService2;
import com.adrninistrator.service.impl.TestAOPService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.AopTestUtils;

import static org.junit.Assert.assertEquals;

// 将AOP代理对象替换为原始对象
public class TestSpAOPMRawGetUse1 extends TestMockBase {

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

        // 经过AOP处理，执行方法时的参数不满足Aspect中的检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService2.test1("");
        assertEquals(TestConstants.MINUS, str);

        assertEquals(0, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));

        // 使用AopTestUtils.getTargetObject获取原始对象
        TestAOPService1 testAOPService1Raw = AopTestUtils.getTargetObject(testAOPService1);

        Whitebox.setInternalState(testAOPService2, testAOPService1Raw);
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        // AOP代理对象被替换为原始对象，不执行Aspect的方法，返回原始对象返回值
        String str = testAOPService2.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        // AOP代理对象被替换为原始对象，不执行Aspect的方法，返回原始对象返回值
        String str = testAOPService2.test1(TestConstants.FLAG1);
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
