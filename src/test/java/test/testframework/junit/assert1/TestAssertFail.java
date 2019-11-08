package test.testframework.junit.assert1;

import com.test.common.TestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//抛出异常
public class TestAssertFail {

    private static final Logger logger = LoggerFactory.getLogger(TestAssertFail.class);

    @Test
    public void test() {

        try {
            Assert.fail(TestConstants.MOCKED);
        } catch (AssertionError e) {

            logger.info("error: {}", e);

            Assert.assertEquals(TestConstants.MOCKED, e.getMessage());
        }
    }
}
