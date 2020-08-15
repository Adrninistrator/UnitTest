package adrninistrator.test.testmock.spring.suppress.method.private1.void1;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// Suppress私有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPrVMethod1 extends TestSpStubBase {

    @Test
    public void test() throws Exception {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4));

        StringBuilder stringBuilder = new StringBuilder();

        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE4, stringBuilder);

        assertEquals(0, stringBuilder.length());

        testServiceA1.test4(stringBuilder);

        assertEquals(0, stringBuilder.length());
    }
}
