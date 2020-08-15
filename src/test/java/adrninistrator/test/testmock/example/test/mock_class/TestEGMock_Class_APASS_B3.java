package adrninistrator.test.testmock.example.test.mock_class;

import adrninistrator.test.testmock.example.base.TestEGMockClassBase;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 重写chooseCheckB()方法，返回"flag3"
public class TestEGMock_Class_APASS_B3 extends TestEGMockClassBase {

    @Test
    public void test() {
        String str = testServiceEG4.test("");

        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, str);
    }

    @Override
    protected String chooseCheckB() {
        return "";
    }

    @Override
    protected String chooseCheckC() {
        return null;
    }
}
