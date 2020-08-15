package adrninistrator.test.testmock.testargs.argmatcher;

import org.mockito.ArgumentMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestArgumentMatcherString2 implements ArgumentMatcher<String> {

    private static final Logger logger = LoggerFactory.getLogger(TestArgumentMatcherString2.class);

    private String flag;

    public TestArgumentMatcherString2(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean matches(String argument) {
        logger.info("argument: {}", argument);

        if (flag.equals(argument)) {
            return true;
        }

        return false;
    }
}
