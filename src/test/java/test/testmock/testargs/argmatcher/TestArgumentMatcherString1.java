package test.testmock.testargs.argmatcher;

import com.test.common.TestConstants;
import org.mockito.ArgumentMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestArgumentMatcherString1 implements ArgumentMatcher<String> {

    private static final Logger logger = LoggerFactory.getLogger(TestArgumentMatcherString1.class);

    @Override
    public boolean matches(String argument) {

        logger.info("argument: {}", argument);

        return TestConstants.FLAG1.equals(argument);
    }
}
