package adrninistrator.test.testframework.junit.assert1;

import adrninistrator.test.testframework.junit.assert1.matchers.TestMatcherTestTableEntity;
import adrninistrator.test.testframework.junit.assert1.matchers.TestMatcherTestTableEntity2;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertThat;

// 使用匹配器
public class TestAssertThat {

    private static final Logger logger = LoggerFactory.getLogger(TestAssertThat.class);

    private TestTableEntity testTableEntity;

    @Before
    public void init() {
        testTableEntity = new TestTableEntity();
        testTableEntity.setId(TestConstants.FLAG1);
        testTableEntity.setFlag(TestConstants.FLAG2);
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Test
    public void test1() {
        assertThat(testTableEntity, new TestMatcherTestTableEntity(TestConstants.FLAG1, TestConstants.FLAG2));

        try {
            assertThat(testTableEntity, new TestMatcherTestTableEntity(TestConstants.FLAG1, TestConstants
                    .FLAG1));
        } catch (AssertionError e) {
            logger.info("error: {}", e);
        }
    }

    // 使用简化的Matcher
    @SuppressWarnings("deprecation")
    @Test
    public void test2() {
        assertThat(testTableEntity, new TestMatcherTestTableEntity2(TestConstants.FLAG1, TestConstants.FLAG2));

        try {
            assertThat(testTableEntity, new TestMatcherTestTableEntity2(TestConstants.FLAG1, TestConstants
                    .FLAG1));
        } catch (AssertionError e) {
            logger.info("error: {}", e);
        }
    }
}
