package adrninistrator.test.testmock.spring.mock.private1.void1;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestPrivateVoidService1Impl;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

// 执行真实方法
@PrepareForTest({TestPrivateVoidService1Impl.class})
public class TestSpMPrVThenCallRealMethod extends TestMockBase {

    @Test
    public void test() throws Exception {

        TestPrivateVoidService1Impl testPrivateVoidService1 = PowerMockito.mock(TestPrivateVoidService1Impl.class);

        PowerMockito.doCallRealMethod().when(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, Mockito
                .any(StringBuilder.class));

        StringBuilder stringBuilder = new StringBuilder();

        Whitebox.invokeMethod(testPrivateVoidService1, TestPrivateVoidService1Impl.NAME_TEST1, stringBuilder);

        assertEquals(TestConstants.NOT_MOCKED, stringBuilder.toString());
    }
}
