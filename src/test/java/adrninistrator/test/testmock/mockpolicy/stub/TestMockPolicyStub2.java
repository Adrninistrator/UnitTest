package adrninistrator.test.testmock.mockpolicy.stub;

import adrninistrator.test.testmock.base.TestMockBase;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub2;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicNonVoidService1;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/*
    PowerMockPolicy实现类TestPolicyStub2的applyClassLoadingPolicy方法中
    通过settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader指定TestStaticPublicNonVoid1的类名
    通过settings.stubMethod对TestStaticPublicNonVoid1、TestPublicNonVoidService1Impl类的方法进行Stub
    对静态方法Stub生效
 */
@MockPolicy(TestPolicyStub2.class)
public class TestMockPolicyStub2 extends TestMockBase {

    @Autowired
    protected TestPublicNonVoidService1 testPublicNonVoidService1;

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
