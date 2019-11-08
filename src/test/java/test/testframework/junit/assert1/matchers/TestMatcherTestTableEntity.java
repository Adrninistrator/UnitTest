package test.testframework.junit.assert1.matchers;

import com.test.dao.entity.TestTableEntity;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMatcherTestTableEntity implements Matcher {

    private static final Logger logger = LoggerFactory.getLogger(TestMatcherTestTableEntity.class);

    private String id;
    private String flag;

    public TestMatcherTestTableEntity(String id, String flag) {

        this.id = id;
        this.flag = flag;
    }

    @Override
    public boolean matches(Object item) {

        if (!(item instanceof TestTableEntity)) {

            logger.error("not instanceof TestTableEntity {}", item);

            return false;
        }

        TestTableEntity testTableEntity = (TestTableEntity) item;

        return id.equals(testTableEntity.getId()) && flag.equals(testTableEntity.getFlag());
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
