package adrninistrator.test.testmock.spring.stub.private1.void1;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Stub私有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPrV1 extends TestSpStubBase {

    @Test
    public void test1() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE4, new Object[]{null})
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testServiceA1.test4(null)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
