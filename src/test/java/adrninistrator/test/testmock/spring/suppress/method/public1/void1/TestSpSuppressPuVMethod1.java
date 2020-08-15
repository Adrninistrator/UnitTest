package adrninistrator.test.testmock.spring.suppress.method.public1.void1;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

// Suppress公有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPuVMethod1 extends TestSpStubBase {

    @Test
    public void test() {
        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2));

        StringBuilder stringBuilder = new StringBuilder();

        testServiceA1.test2(stringBuilder);

        assertEquals(0, stringBuilder.length());

        testServiceB1.test2(stringBuilder);

        assertEquals(0, stringBuilder.length());
    }
}
