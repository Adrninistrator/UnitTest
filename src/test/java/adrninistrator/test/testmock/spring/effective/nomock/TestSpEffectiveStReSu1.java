package adrninistrator.test.testmock.spring.effective.nomock;

import adrninistrator.test.testmock.spring.effective.base.TestSpEffectiveBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertNull;

// PowerMockito类的stub()、replace()与suppress()的生效情况
public class TestSpEffectiveStReSu1 extends TestSpEffectiveBase {

    @Test
    public void test() {
        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.FLAG1);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG1));

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toReturn(TestConstants.FLAG2);

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toReturn(TestConstants.FLAG3);

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .toThrow(new FileNotFoundException(TestConstants.FLAG2));

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1))
                .with((proxy, method, args) -> TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        // PowerMockito.suppress生效
        assertNull(str);
    }
}
