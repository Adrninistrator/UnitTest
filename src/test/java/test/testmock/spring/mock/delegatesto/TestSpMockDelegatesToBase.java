package test.testmock.spring.mock.delegatesto;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import test.testmock.base.TestMockBase;

public abstract class TestSpMockDelegatesToBase extends TestMockBase {

    protected TestServiceA1 testServiceA1;

    @Autowired
    protected TestServiceB1 testServiceB1;

    //调用被委托的方法，委托生效
    @Test
    public void test1() {

        Assert.assertEquals(TestConstants.MOCKED, testServiceA1.test1(""));

        StringBuffer stringBuffer = new StringBuffer();
        testServiceA1.test2(stringBuffer);
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        Assert.assertEquals(TestConstants.MOCKED, testServiceA1.test3(""));

        stringBuffer.setLength(0);
        testServiceA1.test4(stringBuffer);
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }

    //间接调用被委托的方法，委托生效
    @Test
    public void test2() {

        Whitebox.setInternalState(testServiceB1, testServiceA1);

        Assert.assertEquals(TestConstants.MOCKED, testServiceB1.test1(""));

        StringBuffer stringBuffer = new StringBuffer();
        testServiceB1.test2(stringBuffer);
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());
    }
}
