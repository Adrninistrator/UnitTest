package test.testmock.spring.replace.public1.void1;

import com.test.common.TestConstants;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.spring.base.TestSpStubBase;

//Replace公有void方法
@PrepareForTest({TestServiceA1Impl.class})
public class TestSpReplacePuV1 extends TestSpStubBase {

    @Test
    public void test() {

        PowerMockito.replace(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST2)).with(
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
        testServiceA1.test2(stringBuffer);

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.NOT_MOCKED, stringBuffer.toString());

        stringBuffer.setLength(0);
        testServiceB1.test2(stringBuffer);

        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
