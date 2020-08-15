package adrninistrator.test.testframework.junit.annotation.parent;

import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestJUnitParent1 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitParent1.class);

    public static final String NAME_BEFORECLASS = "beforeClassParent";
    public static final String NAME_BEFORE = "beforeParent";
    public static final String NAME_TEST = "testParent";
    public static final String NAME_AFTER = "afterParent";
    public static final String NAME_AFTERCLASS = "afterClassParent";

    public static final String NAME_BEFORECLASS_CHILD = "beforeClassChild";
    public static final String NAME_BEFORE_CHILD = "beforeChild";
    public static final String NAME_TEST_CHILD = "testChild";
    public static final String NAME_AFTER_CHILD = "afterChild";
    public static final String NAME_AFTERCLASS_CHILD = "afterClassChild";

    @BeforeClass
    public static void beforeClassParent() {
        logger.info("#beforeClassParent");

        TestCallTimesUtil.addCallTimes();
    }

    @Before
    public void beforeParent() {
        logger.info("#beforeParent");

        TestCallTimesUtil.addCallTimes();
    }

    @Test
    public void testParent() {
        logger.info("#testParent");

        TestCallTimesUtil.addCallTimes();
    }

    @After
    public void afterParent() {
        logger.info("#afterParent");

        TestCallTimesUtil.addCallTimes();
    }

    @AfterClass
    public static void afterClassParent() {
        logger.info("#afterClassParent");

        TestCallTimesUtil.addCallTimes();
    }
}
