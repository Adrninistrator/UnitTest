package test.testmock.spring.effective.mock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

import java.io.FileNotFoundException;

//Mockito.when()与PowerMockito.stub().toThrow()的生效情况
public class TestSpEffectiveMockStThr2Spy extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        Mockito.doReturn(TestConstants.MOCKED).when(testServiceA1Spy).test1(TestConstants.MOCKED);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        //Mockito.doReturn().when()生效
        String str = testServiceA1Spy.test1(TestConstants.MOCKED);
        Assert.assertEquals(TestConstants.MOCKED, str);

        //Mockito.doReturn().when()，参数不满足Stub条件，返回原始值
        str = testServiceA1Spy.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
