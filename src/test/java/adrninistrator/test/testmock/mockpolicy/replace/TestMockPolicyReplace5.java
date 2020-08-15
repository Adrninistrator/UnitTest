package adrninistrator.test.testmock.mockpolicy.replace;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.replace.TestPolicyReplace5;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.service.impl.TestPublicNonVoidService1Impl;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

// PowerMockPolicy中的settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader操作，与@PrepareForTest注解的效果类似

/*
    在PowerMockPolicy实现类TestPolicyReplace5的applyInterceptionPolicy方法中什么也没做
    在applyClassLoadingPolicy方法中执行settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader操作，与@PrepareForTest注解的效果类似
 */
@MockPolicy(TestPolicyReplace5.class)
public class TestMockPolicyReplace5 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Before
    public void init() {
        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)).with(
                (proxy, method, args) -> TestConstants.MOCKED);

        PowerMockito.replace(PowerMockito.method(TestPublicNonVoidService1Impl.class, TestPublicNonVoidService1Impl.NAME_TEST1)).with(
                (proxy, method, args) -> TestConstants.MOCKED);
    }

    @Test
    public void test1() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        String str = testPublicNonVoidService1.test1("");
        assertEquals(TestConstants.MOCKED, str);
    }
}
