package test.testmock.spring.effective.nomock;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import test.testmock.spring.effective.base.TestSpEffectiveBase;

//PowerMockito.replace().with()执行多次的生效情况
public class TestSpEffectiveReplace1 extends TestSpEffectiveBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).with((proxy, method, args) -> TestConstants.FLAG2);

        String str = testServiceA1.test1("");

        //最后一次PowerMockito.replace生效
        Assert.assertEquals(TestConstants.FLAG2, str);
    }
}
