package test.testmock.spring.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.spring.base.TestSpStubBase;

//Replace公有非void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpReplacePuNV1 extends TestSpStubBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).with(
                (proxy, method, args) -> {
                    //根据请求参数改变返回值
                    if (args[0] == null) {
                        return method.invoke(proxy, args);
                    }

                    return TestConstants.MOCKED;
                });

        String str = testServiceA1.test1(null);

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceB1.test1("");

        Assert.assertEquals(TestConstants.MOCKED, str);
    }
}
