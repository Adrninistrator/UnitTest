package adrninistrator.test.testmock.spring.effective.nomock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

// PowerMockito.stub().toReturn()执行多次的生效情况
public class TestSpEffectiveStubToReturn1 extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toReturn(TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl
                .NAME_TEST1)).toReturn(TestConstants.FLAG2);

        // 最后一次PowerMockito.stub生效
        String str = testServiceA1.test1("");
        assertEquals(TestConstants.FLAG2, str);
    }
}
