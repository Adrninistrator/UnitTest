package adrninistrator.test.testmock.spring.stub.public1.non_void;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.Stubber;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 使用@PrepareForTest指定TestServiceA1Impl.class，stub生效
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpStubPuNV3 extends TestSpStubBase {

    @Test
    public void test1() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toReturn
                (TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        assertEquals(TestConstants.MOCKED, str);

        str = testServiceB1.test1("");

        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test2() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testServiceA1.test1("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test3() {
        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toThrow(new
                RuntimeException(TestConstants.MOCKED));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testServiceB1.test1("")
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test4() {
        Stubber.stubMethod(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1), TestConstants
                .MOCKED);

        String str = testServiceA1.test1("");

        assertEquals(TestConstants.MOCKED, str);
    }

    @Test
    public void test5() {
        Stubber.stubMethod(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1, TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        assertEquals(TestConstants.MOCKED, str);
    }
}
