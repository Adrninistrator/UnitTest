package test.testmock.mockpolicy.mix.spring.mock;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import test.testmock.mockpolicy.policy.spring.TestSpPolicyStubA;

@MockPolicy({TestSpPolicyStubA.class})
public class TestSpMockPolicyStMock1 extends TestSpMockPolicyBase {

    @Test
    public void test() {

        Mockito.when(testServiceA1Mock.test1(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        //Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.FLAG2);
        Assert.assertEquals(TestConstants.FLAG2, str);

        //Mockito.when().thenReturn()，参数不满足，返回null
        str = testServiceA1Mock.test1("");
        Assert.assertNull(str);
    }
}
