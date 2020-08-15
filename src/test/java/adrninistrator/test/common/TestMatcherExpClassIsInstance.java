package adrninistrator.test.common;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 检查异常类是否继承自指定的类，并打印异常类名、堆栈等信息
public class TestMatcherExpClassIsInstance implements Matcher {

    private static final Logger logger = LoggerFactory.getLogger(TestMatcherExpClassIsInstance.class);

    private Class expectedClass;

    public TestMatcherExpClassIsInstance(Class expectedClass) {
        this.expectedClass = expectedClass;
    }

    @Override
    public boolean matches(Object item) {
        if (!(item instanceof Throwable)) {
            logger.error("not instanceof Throwable {}", item);

            return false;
        }

        Throwable throwable = (Throwable) item;

        logger.error("error: ",throwable);

        return expectedClass.isInstance(item);
    }

    @Override
    public void describeMismatch(Object item, Description mismatchDescription) {
        logger.error("{} mismatch!", item);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
    }

    @Override
    public void describeTo(Description description) {
    }
}
