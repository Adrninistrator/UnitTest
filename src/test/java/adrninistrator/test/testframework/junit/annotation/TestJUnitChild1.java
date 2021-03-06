package adrninistrator.test.testframework.junit.annotation;

import adrninistrator.test.testframework.junit.annotation.parent.TestJUnitParent1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/*
    超类的@BeforeClass、@Before方法会在当前类的方法之前运行；
    在超类中声明的@After、@AfterClass方法将在当前类的方法之后运行；
 */
public class TestJUnitChild1 extends TestJUnitParent1 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitChild1.class);

    @BeforeClass
    public static void beforeClassChild() {
        logger.info("#beforeClassChild");

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_BEFORECLASS));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_BEFORE));

        TestCallTimesUtil.addCallTimes();
    }

    @Before
    public void beforeChild() {
        logger.info("#beforeChild");

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_BEFORECLASS));
        assertEquals(TestCallTimesUtil.getCallTimes(TestJUnitChild1.class, NAME_BEFORE_CHILD) + 1,
                TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_BEFORE));

        TestCallTimesUtil.addCallTimes();
    }

    @Test
    public void testChild() {
        logger.info("#testChild");

        TestCallTimesUtil.addCallTimes();
    }

    @After
    public void afterChild() {
        logger.info("#afterChild");

        TestCallTimesUtil.addCallTimes();

        assertEquals(TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_AFTER) + 1, TestCallTimesUtil
                .getCallTimes(TestJUnitChild1.class, NAME_AFTER_CHILD));
    }

    @AfterClass
    public static void afterClassChild() {
        logger.info("#afterClassChild");

        TestCallTimesUtil.addCallTimes();

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_BEFORECLASS));
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_BEFORE));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_TEST));
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_AFTER));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent1.class, NAME_AFTERCLASS));

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild1.class, NAME_BEFORECLASS_CHILD));
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestJUnitChild1.class, NAME_BEFORE_CHILD));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild1.class, NAME_TEST_CHILD));
        assertEquals(2, TestCallTimesUtil.getCallTimes(TestJUnitChild1.class, NAME_AFTER_CHILD));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild1.class, NAME_AFTERCLASS_CHILD));
    }
}
