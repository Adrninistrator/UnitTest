package adrninistrator.test.testframework.junit.assert1;

import com.adrninistrator.common.constants.TestConstants;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// 抛出异常
public class TestAssertFail {

    private static final Logger logger = LoggerFactory.getLogger(TestAssertFail.class);

    @Test
    public void test() {
        try {
            fail(TestConstants.MOCKED);
        } catch (AssertionError e) {
            logger.info("error: {}", e);

            assertEquals(TestConstants.MOCKED, e.getMessage());
        }
    }
}
