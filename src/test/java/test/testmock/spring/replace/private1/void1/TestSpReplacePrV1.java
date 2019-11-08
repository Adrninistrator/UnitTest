package test.testmock.spring.replace.private1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import test.testmock.spring.base.TestSpStubBase;

//Replace私有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpReplacePrV1 extends TestSpStubBase {

    @Test
    public void test() throws Exception {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST_PRIVATE4)).with(
                (proxy, method, args) -> {

                    Assert.assertEquals(1, args.length);

                    Assert.assertTrue(args[0] instanceof StringBuffer);

                    StringBuffer arg1 = (StringBuffer) args[0];

                    //根据请求参数改变返回值
                    if (TestConstants.FLAG1.equals(arg1.toString())) {
                        return method.invoke(proxy, args);
                    }

                    return arg1.append(TestConstants.MOCKED);
                });

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(TestConstants.FLAG1);
        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST_PRIVATE4, stringBuffer);

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, stringBuffer.toString());

        stringBuffer.setLength(0);
        testServiceA1.test4(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
