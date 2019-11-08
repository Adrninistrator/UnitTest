package test.testmock.spring.effective.mock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

//Mockito.when()与PowerMockito类的stub()、replace()的生效情况
public class TestSpEffectiveMockStRe1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        stubCommon(TestServiceA1Impl.class);

        Mockito.when(testServiceA1Mock.test1(TestConstants.MOCKED)).thenReturn(TestConstants.MOCKED);

        stubCommon(TestServiceA1Impl.class);

        //Mockito.when().thenReturn()生效
        String str = testServiceA1Mock.test1(TestConstants.MOCKED);
        Assert.assertEquals(TestConstants.MOCKED, str);

        //Mockito.when().thenReturn()，参数不满足Stub条件，返回null
        str = testServiceA1Mock.test1("");
        Assert.assertNull(str);
    }
}
