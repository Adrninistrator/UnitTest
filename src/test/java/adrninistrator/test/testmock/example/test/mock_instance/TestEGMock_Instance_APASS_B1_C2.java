package adrninistrator.test.testmock.example.test.mock_instance;

import adrninistrator.test.testmock.example.base.TestEGMockInstanceBase;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    不重写chooseCheckB()方法
    重写chooseCheckC()方法，返回"flag2"
 */
public class TestEGMock_Instance_APASS_B1_C2 extends TestEGMockInstanceBase {

    @Test
    public void test() {
        String str = testServiceEG4.test("");

        assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1 + TestConstants.FLAG2, str);
    }

    @Override
    protected String chooseCheckC() {
        return TestConstants.FLAG2;
    }
}
