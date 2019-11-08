package test.testmock.spring.aop;

import com.test.aspect.TestAOPAspect1;
import com.test.common.TestConstants;
import com.test.service.TestAOPService1;
import com.test.service.impl.TestAOPService1Impl;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

//对Aspect进行Stub/Replace
@PrepareForTest({TestAOPAspect1.class})
public class TestSpAOPStubAspect1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Test
    public void test1() {

        PowerMockito.stub(PowerMockito.method(TestAOPAspect1.class, TestAOPAspect1.NAME_CHECK)).toReturn(true);

        doTest();
    }

    @Test
    public void test2() {

        PowerMockito.replace(PowerMockito.method(TestAOPAspect1.class, TestAOPAspect1.NAME_CHECK)).with(
                (proxy, method, args) -> true);

        doTest();
    }

    private void doTest() {

        TestCallTimesUtil.clearCallTimes(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND);

        //Aspect被Stub/Replace，检查条件被跳过，执行原始对象方法
        String str = testAOPService1.testAround("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
