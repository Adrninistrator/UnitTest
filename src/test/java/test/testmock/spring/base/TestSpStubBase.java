package test.testmock.spring.base;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.impl.TestServiceA1Impl;
import org.junit.Assert;
import org.junit.Before;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public abstract class TestSpStubBase extends TestMockBase {

    @Autowired
    protected TestServiceA1 testServiceA1;

    @Autowired
    protected TestServiceB1 testServiceB1;

    @Before
    public void init() throws Exception {

        String str = testServiceA1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        StringBuffer stringBuffer = new StringBuffer();
        testServiceA1.test2(stringBuffer);
        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());

        str = Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST3, "");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        stringBuffer.setLength(0);
        Whitebox.invokeMethod(testServiceA1, TestServiceA1Impl.NAME_TEST4, stringBuffer);
        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());

        str = testServiceB1.test1("");
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        stringBuffer.setLength(0);
        testServiceB1.test2(stringBuffer);
        Assert.assertEquals(TestConstants.NOT_MOCKED, stringBuffer.toString());
    }
}
