package test.testmock.mockpolicy.stub;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.impl.TestPublicNonVoidService1Impl;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;
import test.testmock.mockpolicy.policy.stub.TestPolicyStub5;

//PowerMockPolicy中的settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader操作可以替代@PrepareForTest注解
@MockPolicy(TestPolicyStub5.class)
public class TestMockPolicyStub5 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {

        PowerMockito.stub(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1))
                .toReturn(TestConstants.MOCKED);
        PowerMockito.stub(PowerMockito.method(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl
                .NAME_TEST1)).toReturn(TestConstants.MOCKED);
    }

    @Test
    public void test1() {

        String str = TestStaticPublicNonVoid1.test1("", null);
        Assert.assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {

        String str = testPublicNonVoidService1.test1("");
        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
