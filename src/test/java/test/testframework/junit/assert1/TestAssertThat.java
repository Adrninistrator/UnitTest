package test.testframework.junit.assert1;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testframework.junit.assert1.matchers.TestMatcherTestTableEntity;
import test.testframework.junit.assert1.matchers.TestMatcherTestTableEntity2;

//使用匹配器
public class TestAssertThat {

    private static final Logger logger = LoggerFactory.getLogger(TestAssertThat.class);

    private TestTableEntity testTableEntity;

    @Before
    public void init() {

        testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG2);
    }

    @Test
    public void test1() {

        Assert.assertThat(testTableEntity, new TestMatcherTestTableEntity(TestConstants.FLAG1, TestConstants.FLAG2));

        try {
            Assert.assertThat(testTableEntity, new TestMatcherTestTableEntity(TestConstants.FLAG1, TestConstants
                    .FLAG1));
        } catch (AssertionError e) {

            logger.info("error: {}", e);
        }
    }

    //使用简化的Matcher
    @Test
    public void test2() {

        Assert.assertThat(testTableEntity, new TestMatcherTestTableEntity2(TestConstants.FLAG1, TestConstants.FLAG2));

        try {
            Assert.assertThat(testTableEntity, new TestMatcherTestTableEntity2(TestConstants.FLAG1, TestConstants
                    .FLAG1));
        } catch (AssertionError e) {

            logger.info("error: {}", e);
        }
    }
}
