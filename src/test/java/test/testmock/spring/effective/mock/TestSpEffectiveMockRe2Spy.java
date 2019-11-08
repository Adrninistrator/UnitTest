package test.testmock.spring.effective.mock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

//Mockito.when()与PowerMockito.replace()的生效情况
public class TestSpEffectiveMockRe2Spy extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        Mockito.doReturn(TestConstants.FLAG2).when(testServiceA1Spy).test1(TestConstants.FLAG2);

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG3);

        //Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.FLAG2);
        Assert.assertEquals(TestConstants.FLAG2, str);

        //Mockito.doReturn().when()，参数不满足Stub条件，返回原始值
        str = testServiceA1Spy.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
