package adrninistrator.test.testmock.spring.stub.private1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Stub私有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPrNV1 extends TestSpStubBase {

    @Test
    public void test1() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).toReturn
                (TestConstants.MOCKED);

        String str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, "");

        assertEquals(TestConstants.MOCKED, str);

        str = testServiceA1.test3("");

        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() throws Exception {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, "")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test3() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).toThrow
                (new RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testServiceA1.test3("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
