package adrninistrator.test.testmock.mockpolicy.mix.spring.mock;

import adrninistrator.test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import adrninistrator.test.testmock.mockpolicy.policy.spring.TestSpPolicyReplaceA;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;

@MockPolicy({TestSpPolicyReplaceA.class})
public class TestSpMockPolicyReMock2Spy extends TestSpMockPolicyBase {

    @Test
    public void test() {
        Mockito.doReturn(TestConstants.FLAG2).when(testServiceA1Spy).test1(TestConstants.FLAG2);

        // Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, str);

        // Mockito.doReturn().when()，参数不满足，返回原始值
        str = testServiceA1Spy.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
