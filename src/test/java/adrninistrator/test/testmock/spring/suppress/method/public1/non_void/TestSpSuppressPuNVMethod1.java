package adrninistrator.test.testmock.spring.suppress.method.public1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Suppress公有非void方法
// 使用@PrepareForTest，指定TestServiceA1.class，suppress不生效
@PrepareForTest({TestServiceA1.class})
public class TestSpSuppressPuNVMethod1 extends TestSpStubBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        String str = testServiceA1.test1("");

        assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceB1.test1("");

        assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
