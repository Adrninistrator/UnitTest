package adrninistrator.test.testmock.spring.mock.public1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.service.impl.TestPublicVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 抛出异常
public class TestSpMPuVThenThrow extends TestMockBase {

    @Test
    public void test1() throws Exception {
        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        Mockito.doThrow(new RuntimeException(TestConstants.MOCKED)).when(testPublicVoidService1).test1(Mockito.any
                (StringBuilder.class));

        // 满足Stub条件，抛出异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicVoidService1.test1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() throws Exception {
        TestPublicVoidService1 testPublicVoidService1 = Mockito.mock(TestPublicVoidService1.class);

        PowerMockito.when(testPublicVoidService1, TestPublicVoidService1Impl.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenThrow(new RuntimeException(TestConstants.MOCKED));

        // 满足Stub条件，抛出异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                testPublicVoidService1.test1(new StringBuilder())
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
