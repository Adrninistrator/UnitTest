package test.testmock.spring.effective.nomock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.common.TestMatcherExpClassEquals;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

import java.io.FileNotFoundException;

//PowerMockito.stub().toReturn()执行多次的生效情况
public class TestSpEffectiveStubToReturn1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toReturn(TestConstants.FLAG2);

        //最后一次PowerMockito.stub生效
        String str = testServiceA1.test1("");
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
