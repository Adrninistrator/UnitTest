package test.testmock.spring.suppress.method.private1.non_void;

import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.spring.base.TestSpStubBase;

//Suppress私有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPrNVMethod1 extends TestSpStubBase {

    @Test
    public void test() throws Exception {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE3));

        String str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE3, "");

        Assert.assertNull(str);

        str = testServiceA1.test3("");

        Assert.assertNull(str);
    }
}
