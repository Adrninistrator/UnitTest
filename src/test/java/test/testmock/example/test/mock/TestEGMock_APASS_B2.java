package test.testmock.example.test.mock;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import test.testmock.example.base.TestEGMockBase;

public class TestEGMock_APASS_B2 extends TestEGMockBase {

    @Test
    public void test() {

        String str = testServiceEG4.test("");

        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.FLAG2, str);
    }

    @Override
    protected String chooseCheckB() {
        return TestConstants.FLAG2;
    }

    @Override
    protected String chooseCheckC() {
        return null;
    }
}
