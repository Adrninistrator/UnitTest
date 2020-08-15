package adrninistrator.test.testmock.spring.replace.private1.void1;

import adrninistrator.test.testmock.spring.base.TestSpStubBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.impl.TestServiceA1Impl;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Replace私有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpReplacePrV1 extends TestSpStubBase {

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4)).with(
                (proxy, method, args) -> {

                    assertEquals(1, args.length);

                    assertTrue(args[0] instanceof StringBuilder);

                    StringBuilder arg1 = (StringBuilder) args[0];

                    // 根据请求参数改变返回值
                    if (TestConstants.FLAG1.equals(arg1.toString())) {
                        return method.invoke(proxy, args);
                    }

                    return arg1.append(TestConstants.MOCKED);
                });

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TestConstants.FLAG1);
        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE4, stringBuilder);

        assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, stringBuilder.toString());

        stringBuilder.setLength(0);
        testServiceA1.test4(stringBuilder);

        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }
}
