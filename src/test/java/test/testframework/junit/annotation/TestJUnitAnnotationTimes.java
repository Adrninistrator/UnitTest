package test.testframework.junit.annotation;

import com.test.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    @BeforeClass对应方法在对应的测试类执行时，会执行一次，且在其他方法前执行
    @AfterClass对应方法在对应的测试类执行时，会执行一次，且在其他方法后执行
    @Before对应方法在每个@Test方法执行前都会执行一次
    @After对应方法在每个@Test方法执行后都会执行一次
 */
public class TestJUnitAnnotationTimes {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitAnnotationTimes.class);

    public static final String NAME_BEFORECLASS = "beforeClass";
    public static final String NAME_BEFORE = "before";
    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";
    public static final String NAME_AFTER = "after";
    public static final String NAME_AFTERCLASS = "afterClass";

    @BeforeClass
    public static void beforeClass() {

        logger.info("beforeClass");

        TestCallTimesUtil.addCallTimes();
    }

    @Before
    public void before() {

        logger.info("before");

        TestCallTimesUtil.addCallTimes();
    }

    @Test
    public void test1() {

        logger.info("test1");

        TestCallTimesUtil.addCallTimes();
    }

    @Test
    public void test2() {

        logger.info("test2");

        TestCallTimesUtil.addCallTimes();
    }

    @After
    public void after() {

        logger.info("after");

        TestCallTimesUtil.addCallTimes();
    }

    @AfterClass
    public static void afterClass() {

        logger.info("afterClass");

        TestCallTimesUtil.addCallTimes();

        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationTimes.class, NAME_BEFORECLASS));
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationTimes.class, NAME_BEFORE));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationTimes.class, NAME_TEST1));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationTimes.class, NAME_TEST2));
        Assert.assertEquals(2, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationTimes.class, NAME_AFTER));
        Assert.assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitAnnotationTimes.class, NAME_AFTERCLASS));
    }
}
