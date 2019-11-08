package test.testmock.spring.suppress.method.public1.non_void;

import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.spring.base.TestSpStubBase;

//Suppress公有非void方法
//使用@PrepareForTest，指定TestServiceA1Impl.class，suppress生效
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpSuppressPuNVMethod2 extends TestSpStubBase {

    @Test
    public void test() {

        PowerMockito.suppress(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1));

        String str = testServiceA1.test1("");

        Assert.assertNull(str);

        str = testServiceB1.test1("");

        Assert.assertNull(str);
    }
}
