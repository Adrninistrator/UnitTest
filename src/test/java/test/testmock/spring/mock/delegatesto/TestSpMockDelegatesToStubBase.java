package test.testmock.spring.mock.delegatesto;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public abstract class TestSpMockDelegatesToStubBase extends TestMockBase {

    protected TestServiceA1 testServiceA1Delegate;

    @Autowired
    protected TestServiceB1 testServiceB1;

    //调用被Stub的方法，Stub生效
    @Test
    public void test1() {

        Assert.assertEquals(TestConstants.FLAG1, testServiceA1Delegate.test1(""));

        StringBuffer stringBuffer = new StringBuffer();
        testServiceA1Delegate.test2(stringBuffer);
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        Assert.assertEquals(TestConstants.FLAG3, testServiceA1Delegate.test3(""));

        stringBuffer.setLength(0);
        testServiceA1Delegate.test4(stringBuffer);
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }

    //间接调用被Stub的方法，Stub生效
    @Test
    public void test2() {

        Whitebox.setInternalState(testServiceB1, testServiceA1Delegate);

        Assert.assertEquals(TestConstants.FLAG1, testServiceB1.test1(""));

        StringBuffer stringBuffer = new StringBuffer();
        testServiceB1.test2(stringBuffer);
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
