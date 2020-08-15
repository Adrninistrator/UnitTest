package adrninistrator.test.testmock.spring.stub.public1.void1;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Stub公有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPuV1 extends TestSpStubBase {

    @Test
    public void test1() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testServiceA1.test2(null)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testServiceB1.test2(null)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
