package adrninistrator.test.testmock.spring.aop.method;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.aspect.TestAOPAspectMethod1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.impl.TestAOPService1Impl;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// 对Aspect进行Stub/Replace
@PrepareForTest({TestAOPAspectMethod1.class})
public class TestSpAOPMStubAspect1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Test
    public void test1() {
        PowerMockito.stub(PowerMockito.method(TestAOPAspectMethod1.class, TestAOPAspectMethod1.NAME_CHECK)).toReturn(true);

        doTest();
    }

    @Test
    public void test2() {
        PowerMockito.replace(PowerMockito.method(TestAOPAspectMethod1.class, TestAOPAspectMethod1.NAME_CHECK)).with(
                (proxy, method, args) -> true);

        doTest();
    }

    private void doTest() {
        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        // Aspect被Stub/Replace，检查条件被跳过，执行原始对象方法
        String str = testAOPService1.testAround("");
        assertEquals(TestConstants.NOT_MOCKED, str);

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
