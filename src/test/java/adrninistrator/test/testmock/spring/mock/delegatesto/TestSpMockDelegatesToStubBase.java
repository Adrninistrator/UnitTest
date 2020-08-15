package adrninistrator.test.testmock.spring.mock.delegatesto;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public abstract class TestSpMockDelegatesToStubBase extends TestMockBase {

    protected TestServiceA1 testServiceA1Delegate;

    @Autowired
    protected TestServiceB1 testServiceB1;

    // 调用被Stub的方法，Stub生效
    @Test
    public void test1() {
        // test1方法被Stub设置为返回TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1, testServiceA1Delegate.test1(""));

        StringBuilder stringBuilder = new StringBuilder();
        testServiceA1Delegate.test2(stringBuilder);
        // test2方法被委托为将参数值设置为TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        // test3方法被Stub设置为返回TestConstants.FLAG3
        assertEquals(TestConstants.FLAG3, testServiceA1Delegate.test3(""));

        stringBuilder.setLength(0);
        testServiceA1Delegate.test4(stringBuilder);
        // test2方法被委托为将参数值设置为TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }

    // 间接调用被Stub的方法，Stub生效
    @Test
    public void test2() {
        Whitebox.setInternalState(testServiceB1, testServiceA1Delegate);

        assertEquals(TestConstants.FLAG1, testServiceB1.test1(""));

        StringBuilder stringBuilder = new StringBuilder();
        testServiceB1.test2(stringBuilder);
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }
}
