package test.testmock.spring.effective.mock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

//Mockito.when()与PowerMockito.replace()的生效情况
public class TestSpEffectiveMockRe1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        Mockito.when(testServiceA1Mock.test1(TestConstants.FLAG2)).thenReturn(TestConstants.FLAG2);

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG3);

        //Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.FLAG2);
        Assert.assertEquals(TestConstants.FLAG2, str);

        //Mockito.when().thenReturn()，参数不满足Stub条件，返回null
        str = testServiceA1Mock.test1("");
        Assert.assertNull(str);
    }
}
