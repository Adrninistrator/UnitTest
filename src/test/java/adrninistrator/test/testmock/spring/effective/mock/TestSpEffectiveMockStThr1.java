package adrninistrator.test.testmock.spring.effective.mock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// Mockito.when()与PowerMockito.stub().toThrow()的生效情况
public class TestSpEffectiveMockStThr1 extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        Mockito.when(testServiceA1Mock.test1(TestConstants.MOCKED)).thenReturn(TestConstants.MOCKED);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        // Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.MOCKED);
        assertEquals(TestConstants.MOCKED, str);

        // Mockito.when().thenReturn()，参数不满足Stub条件，返回null
        str = testServiceA1Mock.test1("");
        assertNull(str);
    }
}
