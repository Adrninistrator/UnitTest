package adrninistrator.test.testmock.spring.suppress.method.private1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertNull;

// Suppress私有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPrNVMethod1 extends TestSpStubBase {

    @Test
    public void test() throws Exception {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3));

        String str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, "");

        assertNull(str);

        str = testServiceA1.test3("");

        assertNull(str);
    }
}
