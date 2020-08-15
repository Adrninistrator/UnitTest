package adrninistrator.test.testmock.spring.suppress.method.public1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.SuppressCode;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertNull;

// Suppress公有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPuNVMethod3 extends TestSpStubBase {

    @Test
    public void test() {
        SuppressCode.suppressMethod(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        String str = testServiceA1.test1("");

        assertNull(str);

        str = testServiceB1.test1("");

        assertNull(str);
    }
}
