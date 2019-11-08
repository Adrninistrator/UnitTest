package test.testmock.spring.stub.public1.non_void;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import test.testmock.spring.base.TestSpStubBase;

//使用@PrepareForTest指定TestServiceA1.class，stub不生效
@PrepareForTest({TestServiceA1.class})
public class TestSpStubPuNV2 extends TestSpStubBase {

    @Test
    public void test() {

        PowerMockito.stub(PowerMockito.method(TestServiceA1Impl.class, TestServiceA1Impl.NAME_TEST1)).toReturn
                (TestConstants.MOCKED);

        String str = testServiceA1.test1("");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        str = testServiceB1.test1("");

        Assert.assertEquals(TestConstants.NOT_MOCKED, str);
    }
}
