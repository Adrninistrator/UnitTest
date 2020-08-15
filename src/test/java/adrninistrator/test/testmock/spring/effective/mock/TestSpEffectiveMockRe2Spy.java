package adrninistrator.test.testmock.spring.effective.mock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// Mockito.when()与PowerMockito.replace()的生效情况
public class TestSpEffectiveMockRe2Spy extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        Mockito.doReturn(TestConstants.FLAG2).when(testServiceA1Spy).test1(TestConstants.FLAG2);

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG3);

        // Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.FLAG2);
        assertEquals(TestConstants.FLAG2, str);

        // Mockito.doReturn().when()，参数不满足Stub条件，返回原始值
        str = testServiceA1Spy.test1("");
        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
