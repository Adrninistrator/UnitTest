package test.testmock.example.test.nomock;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import test.testmock.example.base.TestEGNoMockBase;

public class TestEGNoMock_APASS_B3 extends TestEGNoMockBase {

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
