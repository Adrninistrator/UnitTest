package test.testmock.example.test.mock;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import test.testmock.example.base.TestEGMockBase;

public class TestEGMock_APASS_B3 extends TestEGMockBase {

    @Test
    public void test() {

        String str = testServiceEG4.test("");

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, str);
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
