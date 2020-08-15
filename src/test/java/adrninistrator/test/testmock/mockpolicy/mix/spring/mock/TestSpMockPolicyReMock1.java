package adrninistrator.test.testmock.mockpolicy.mix.spring.mock;

import adrninistrator.test.testmock.mockpolicy.mix.spring.base.TestSpMockPolicyBase;
import adrninistrator.test.testmock.mockpolicy.policy.spring.TestSpPolicyReplaceA;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.MockPolicy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@MockPolicy({TestSpPolicyReplaceA.class})
public class TestSpMockPolicyReMock1 extends TestSpMockPolicyBase {

    @Test
    public void test() {
        Mockito.when(testServiceA1Mock.test1(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        // Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, str);

        // Mockito.when().thenReturn()，参数不满足，返回null
        str = testServiceA1Mock.test1("");
        assertNull(str);
    }
}
