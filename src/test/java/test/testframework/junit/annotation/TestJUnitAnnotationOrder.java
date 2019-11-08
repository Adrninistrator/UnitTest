package test.testframework.junit.annotation;

import com.test.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//注解对应方法执行顺序：@BeforeClass->@Before->@Test->@After->@AfterClass
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

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @Before
    public void before() {

        logger.info("before");

        TestCallTimesUtil.addCallTimes();

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @Test
    public void test() {

        logger.info("test");

        TestCallTimesUtil.addCallTimes();

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @After
    public void after() {

        logger.info("after");

        TestCallTimesUtil.addCallTimes();

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }

    @AfterClass
    public static void afterClass() {

        logger.info("afterClass");

        TestCallTimesUtil.addCallTimes();

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORECLASS));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_BEFORE));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_TEST));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTER));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationOrder.class, NAME_AFTERCLASS));
    }
}
