package test.testframework.junit.assert1;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testframework.junit.assert1.matchers.TestMatcherSimple;

//使用匹配器，使用匿名类
public class TestAssertThatAnonymous {

    private static final Logger logger = LoggerFactory.getLogger(TestAssertThatAnonymous.class);

    private TestTableEntity testTableEntity;

    @Before
    public void init() {

        testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG2);
    }

    @Test
    public void test1() {

        Assert.assertThat(testTableEntity, new Matcher<TestTableEntity>() {
            @Override
            public boolean matches(Object item) {

                if (!(item instanceof TestTableEntity)) {

                    logger.error("not instanceof TestTableEntity {}", item);

                    return false;
                }

                TestTableEntity testTableEntity = (TestTableEntity) item;

                return TestConstants.FLAG1.equals(testTableEntity.getId()) && TestConstants.FLAG2.equals
                        (testTableEntity.getFlag());
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
        });
    }

    //使用简化的Matcher
    @Test
    public void test2() {

        Assert.assertThat(testTableEntity, new TestMatcherSimple<TestTableEntity>() {

            @Override
            public boolean matches2(TestTableEntity item) {

                return TestConstants.FLAG1.equals(item.getId()) && TestConstants.FLAG2.equals
                        (item.getFlag());
            }
        });
    }
}
