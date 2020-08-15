package adrninistrator.test.testmock.mockpolicy.replace;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.replace.TestPolicyReplace4;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/*
    在PowerMockPolicy实现类TestPolicyReplace4中对TestStaticPublicNonVoid1、TestPublicNonVoidService1Impl类的方法进行了Replace，修改返回值
    在TestPolicyReplace4类的applyClassLoadingPolicy方法中，调用settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader方法时参数使用字符串数组指定类名
    在TestPolicyReplace4类的applyInterceptionPolicy方法中，使用settings.setMethodsToProxy方法设置Replace
 */
@MockPolicy(TestPolicyReplace4.class)
public class TestMockPolicyReplace4 extends TestMockBase {

    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

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
