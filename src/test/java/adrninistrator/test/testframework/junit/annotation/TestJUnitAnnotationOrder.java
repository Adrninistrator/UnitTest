package adrninistrator.test.testframework.junit.annotation;

import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 注解对应方法执行顺序：@BeforeClass->@Before->@Test->@After->@AfterClass
public class TestJUnitAnnotationOrder {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitAnnotationOrder.class);

    public static final String NAME_BEFORECLASS = "beforeClass";
    public static final String NAME_BEFORE = "before";
    public static final String NAME_TEST = "test";
    public static final String NAME_AFTER = "after";
    public static final String NAME_AFTERCLASS = "afterClass";

    @BeforeClass
    public static void beforeClass() {
        logger.info("beforeClass");

        TestCallTimesUtil.addCallTimes();

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @Before
    public void before() {
        logger.info("before");

        TestCallTimesUtil.addCallTimes();

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @Test
    public void test() {
        logger.info("test");

        TestCallTimesUtil.addCallTimes();

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @After
    public void after() {
        logger.info("after");

        TestCallTimesUtil.addCallTimes();

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @AfterClass
    public static void afterClass() {
        logger.info("afterClass");

        TestCallTimesUtil.addCallTimes();

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }
}
