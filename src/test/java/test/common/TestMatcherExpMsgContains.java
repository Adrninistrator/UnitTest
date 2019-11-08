package test.common;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//检查异常信息是否包含指定内容，并打印
public class TestMatcherExpMsgContains implements Matcher {

    private static final Logger logger = LoggerFactory.getLogger(TestMatcherExpMsgContains.class);

    private String expectedMsg;

    public TestMatcherExpMsgContains(String expectedMsg) {

        this.expectedMsg = expectedMsg;
    }

    @Override
    public boolean matches(Object item) {

        if (!(item instanceof String)) {

            logger.error("not instanceof String {}", item);

            return false;
        }

        String message = (String) item;

        logger.info("\r\nThrowable message: {}", message);

        return expectedMsg.contains(message);
    }

    @Override
    public void describeMismatch(Object item, Description mismatchDescription) {
        logger.error("{} mismatch!", item);
    }

    @Override
    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
    }

    @Override
    public void describeTo(Description description) {
    }
}
