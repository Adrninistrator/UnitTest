package test.testmock.spring.effective.mock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import test.common.TestMatcherExpClassIsInstance;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

//Mockito.when()与PowerMockito类的stub()、replace()的生效情况
public class TestSpEffectiveMockStRe2Spy extends TestSpEffectiveBase {

    @Test
    public void test() {

        stubCommon(TestServiceA1Impl.class);

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(TestConstants.MOCKED);

        stubCommon(TestServiceA1Impl.class);

        //Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.MOCKED);
        Assert.assertEquals(TestConstants.MOCKED, str);

        //Mockito.doReturn().when()，参数不满足Stub条件，返回原始值
        str = testServiceA1Spy.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
