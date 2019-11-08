package test.testmock.spring.effective.mock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

//Mockito.when()与PowerMockito.suppress()的生效情况
public class TestSpEffectiveMockSu1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        Mockito.when(testServiceA1Mock.test1(TestConstants.FLAG1)).thenReturn(TestConstants.FLAG1);

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        //Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.FLAG1);
        Assert.assertEquals(TestConstants.FLAG1, str);

        //Mockito.when().thenReturn()参数不满足条件，返回null
        str = testServiceA1Mock.test1("");
        Assert.assertNull(str);
    }
}
