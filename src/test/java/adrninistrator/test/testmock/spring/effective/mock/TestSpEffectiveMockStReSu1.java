package adrninistrator.test.testmock.spring.effective.mock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()与PowerMockito类的stub()、replace()与suppress()的生效情况
public class TestSpEffectiveMockStReSu1 extends TestSpEffectiveBase {

    @Test
    public void test() {
        stubCommon2(TestServiceA1Impl.class);

        Mockito.when(testServiceA1Mock.test1(TestConstants.MOCKED)).thenReturn(TestConstants.MOCKED);

        stubCommon2(TestServiceA1Impl.class);

        // Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.MOCKED);
        assertEquals(TestConstants.MOCKED, str);

        // Mockito.when().thenReturn()，参数不满足Stub条件，返回null
        str = testServiceA1Mock.test1("");
        assertNull(str);
    }
}
