package test.testmock.spring.replace.private1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.spring.base.TestSpStubBase;

//Replace私有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpReplacePrNV1 extends TestSpStubBase {

    @Test
    public void test1() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3)).with(
                (proxy, method, args) -> {
                    //根据请求参数改变返回值
                    if (args[0] == null) {
                        return method.invoke(proxy, args);
                    }

                    return TestConstants.MOCKED;
                });

        String str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, null);

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceA1.test3("");

        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
