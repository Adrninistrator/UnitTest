package test.testmock.spring.aop;

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

//对原始对象进行Stub/Replace
@PrepareForTest({TestAOPService1Impl.class})
public class TestSpAOPStubTarget1 extends TestMockBase {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Test
    public void test1() {

        PowerMockito.stub(PowerMockito.method(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND))
                .toReturn(TestConstants.MOCKED);

        doTest();
    }

    @Test
    public void test2() {

        PowerMockito.replace(PowerMockito.method(TestAOPService1Impl.class, TestAOPService1Impl.NAME_TESTAROUND))
                .with((proxy, method, args) -> TestConstants.MOCKED);

        doTest();
    }

    private void doTest() {

        //经过AOP Aspect处理，不满足检查条件，返回TestAOPAspect1对应方法的返回值，不执行原始对象方法
        String str = testAOPService1.testAround("");
        Assert.assertEquals(TestConstants.MINUS, str);

        //经过AOP Aspect处理，满足检查条件，执行TestAOPService1Impl类的方法，Stub/Replace生效
        str = testAOPService1.testAround(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.MOCKED, str);

        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestAOPService1Impl.class, TestAOPService1Impl
                .NAME_TESTAROUND));
    }
}
