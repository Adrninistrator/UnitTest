package test.testmock.mockpolicy.mix.spring.mock;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.MockPolicy;
import test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import test.testmock.mockpolicy.policy.spring.TestSpPolicyStubA;

@MockPolicy({TestSpPolicyStubA.class})
public class TestSpMockPolicyStMock2Spy extends TestSpMockPolicyBase {

    @Test
    public void test() {

        Mockito.doReturn(TestConstants.FLAG2).when(testServiceA1Spy).test1(TestConstants.FLAG2);

        //Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.FLAG2);
        Assert.assertEquals(TestConstants.FLAG2, str);

        //Mockito.doReturn().when()，参数不满足，返回原始值
        str = testServiceA1Spy.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
