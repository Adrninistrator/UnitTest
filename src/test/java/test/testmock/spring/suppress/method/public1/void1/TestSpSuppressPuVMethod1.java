package test.testmock.spring.suppress.method.public1.void1;

import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.spring.base.TestSpStubBase;

//Suppress公有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPuVMethod1 extends TestSpStubBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2));

        StringBuffer stringBuffer = new StringBuffer();

        testServiceA1.test2(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());

        testServiceB1.test2(stringBuffer);

        Assert.assertEquals(0, stringBuffer.length());
    }
}
