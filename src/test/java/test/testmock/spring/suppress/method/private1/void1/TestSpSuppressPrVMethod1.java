package test.testmock.spring.suppress.method.private1.void1;

import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.spring.base.TestSpStubBase;

//Suppress私有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPrVMethod1 extends TestSpStubBase {

    @Test
    public void test() throws Exception {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4));

        StringBuffer stringBuffer = new StringBuffer();

        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE4, stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());

        testServiceA1.test4(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());
    }
}
