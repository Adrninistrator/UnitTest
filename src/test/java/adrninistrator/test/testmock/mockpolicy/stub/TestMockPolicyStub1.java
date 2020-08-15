package adrninistrator.test.testmock.mockpolicy.stub;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import adrninistrator.test.testmock.mockpolicy.policy.stub.TestPolicyStub1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

/*
    PowerMockPolicy实现类TestPolicyStub1的applyClassLoadingPolicy方法中
    未通过settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader指定TestStaticPublicNonVoid1的类名
    stub未生效
 */
@MockPolicy(TestPolicyStub1.class)
public class TestMockPolicyStub1 extends TestMockNoSpBase {

    @Test
    public void test() {
        String str = TestStaticPublicNonVoid1.test1("", null);
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
