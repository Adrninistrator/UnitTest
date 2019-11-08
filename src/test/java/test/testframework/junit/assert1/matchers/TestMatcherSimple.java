package test.testframework.junit.assert1.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestMatcherSimple<T> implements Matcher<T> {

    private static final Logger logger = LoggerFactory.getLogger(TestMatcherSimple.class);

    @Override
    public boolean matches(Object item) {

        if (item == null) {
            return false;
        }

        T item2 = (T) item;

        return matches2(item2);
    }

    public abstract boolean matches2(T item);

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
