package adrninistrator.test.testframework.junit.annotation;

import adrninistrator.test.testframework.junit.annotation.parent.TestJUnitParent2;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 当子类覆盖超类的注解对应方法时，超类中的方法不会执行
public class TestJUnitChild2 extends TestJUnitParent2 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitChild2.class);

    @BeforeClass
    public static void beforeClass() {
        logger.info("#beforeClassChild");

        TestCallTimesUtil.addCallTimes();
    }

    @Before
    public void before() {
        logger.info("#beforeChild");

        TestCallTimesUtil.addCallTimes();
    }

    @Test
    public void test() {
        logger.info("#testChild");

        TestCallTimesUtil.addCallTimes();
    }

    @After
    public void after() {
        logger.info("#afterChild");

        TestCallTimesUtil.addCallTimes();
    }

    @AfterClass
    public static void afterClass() {
        logger.info("#afterClassChild");

        TestCallTimesUtil.addCallTimes();

        // 超类中的方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent2.class, NAME_BEFORECLASS));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent2.class, NAME_BEFORE));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent2.class, NAME_TEST));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent2.class, NAME_AFTER));
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestJUnitParent2.class, NAME_AFTERCLASS));

        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild2.class, NAME_BEFORECLASS));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild2.class, NAME_BEFORE));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild2.class, NAME_TEST));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild2.class, NAME_AFTER));
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestJUnitChild2.class, NAME_AFTERCLASS));
    }
}
