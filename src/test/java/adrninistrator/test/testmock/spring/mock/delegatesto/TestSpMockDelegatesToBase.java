package adrninistrator.test.testmock.spring.mock.delegatesto;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public abstract class TestSpMockDelegatesToBase extends TestMockBase {

    protected TestServiceA1 testServiceA1;

    @Autowired
    protected TestServiceB1 testServiceB1;

    // 调用被委托的方法，委托生效
    @Test
    public void test1() {
        assertEquals(TestConstants.MOCKED, testServiceA1.test1(""));

        StringBuilder stringBuilder = new StringBuilder();
        testServiceA1.test2(stringBuilder);
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        assertEquals(TestConstants.MOCKED, testServiceA1.test3(""));

        stringBuilder.setLength(0);
        testServiceA1.test4(stringBuilder);
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }

    // 间接调用被委托的方法，委托生效
    @Test
    public void test2() {
        Whitebox.setInternalState(testServiceB1, testServiceA1);

        assertEquals(TestConstants.MOCKED, testServiceB1.test1(""));

        StringBuilder stringBuilder = new StringBuilder();
        testServiceB1.test2(stringBuilder);
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());
    }
}
