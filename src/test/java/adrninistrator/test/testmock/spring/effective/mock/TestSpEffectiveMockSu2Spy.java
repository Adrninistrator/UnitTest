package adrninistrator.test.testmock.spring.effective.mock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()与PowerMockito.suppress()的生效情况
public class TestSpEffectiveMockSu2Spy extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        Mockito.doReturn(TestConstants.FLAG1).when(testServiceA1Spy).test1(TestConstants.FLAG1);

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        // Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.FLAG1);
        assertEquals(TestConstants.FLAG1, str);

        // Mockito.doReturn().when()参数不满足条件，返回null
        str = testServiceA1Spy.test1("");
        assertNull(str);
    }
}
