package adrninistrator.test.testmock.spring.effective.mock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()与PowerMockito类的stub()、replace()与suppress()的生效情况
public class TestSpEffectiveMockStReSu2Spy extends TestSpEffectiveBase {

    @Test
    public void test() {
        stubCommon2(TestServiceA1Impl.class);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(TestConstants.MOCKED);

        stubCommon2(TestServiceA1Impl.class);

        // Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.MOCKED);
        assertEquals(TestConstants.MOCKED, str);

        // Mockito.doReturn().when()，参数不满足Stub条件，返回null
        str = testServiceA1Spy.test1("");
        assertNull(str);
    }
}
