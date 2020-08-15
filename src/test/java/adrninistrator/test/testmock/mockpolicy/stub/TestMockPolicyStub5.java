package adrninistrator.test.testmock.mockpolicy.stub;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub5;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/*
    在PowerMockPolicy实现类TestPolicyStub5的applyInterceptionPolicy方法中什么也没做
    在applyClassLoadingPolicy方法中执行settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader操作，与@PrepareForTest注解的效果类似
    在调用addFullyQualifiedNamesOfClassesToLoadByMockClassloader方法时指定了多个类名
 */
@MockPolicy(TestPolicyStub5.class)
public class TestMockPolicyStub5 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Autowired
    private TestServiceA1 testServiceA1;

    @Before
    public void init() {
        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)).toReturn(TestConstants.MOCKED);
        PowerMockito.stub(PowerMockito.method(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1)).toReturn(TestConstants.MOCKED);
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toReturn(TestConstants.MOCKED);
    }

    @Test
    public void test() {
        // TestPolicyStub5的applyClassLoadingPolicy方法中指定了TestStaticPublicNonVoid1类，Stub生效
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.NOT_MOCKED, str);

        // TestPolicyStub5的applyClassLoadingPolicy方法中指定了TestPublicNonVoidService1Impl类，Stub生效
        str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.MOCKED, str);

        // TestPolicyStub5的applyClassLoadingPolicy方法中未指定TestServiceA1Impl类，Stub不生效
        str = testServiceA1.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
