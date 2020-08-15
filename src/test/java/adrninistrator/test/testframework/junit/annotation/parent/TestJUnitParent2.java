package adrninistrator.test.testframework.junit.annotation.parent;

import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestJUnitParent2 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitParent2.class);

    public static final String NAME_BEFORECLASS = "beforeClass";
    public static final String NAME_BEFORE = "before";
    public static final String NAME_TEST = "test";
    public static final String NAME_AFTER = "after";
    public static final String NAME_AFTERCLASS = "afterClass";

    @BeforeClass
    public static void beforeClass() {
        logger.info("beforeClassParent");

        TestCallTimesUtil.addCallTimes();
    }

    @Before
    public void before() {
        logger.info("beforeParent");

        TestCallTimesUtil.addCallTimes();
    }

    @Test
    public void test() {
        logger.info("#testParent");

        TestCallTimesUtil.addCallTimes();
    }

    @After
    public void after() {
        logger.info("afterParent");

        TestCallTimesUtil.addCallTimes();
    }

    @AfterClass
    public static void afterClass() {
        logger.info("afterClassParent");

        TestCallTimesUtil.addCallTimes();
    }
}
