package adrninistrator.test.testmock.spring.effective.nomock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// PowerMockito.replace().with()执行多次的生效情况
public class TestSpEffectiveReplace1 extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).with((proxy, method, args) -> TestConstants.FLAG2);

        String str = testServiceA1.test1("");

        // 最后一次PowerMockito.replace生效
        assertEquals(TestConstants.FLAG2, str);
    }
}
