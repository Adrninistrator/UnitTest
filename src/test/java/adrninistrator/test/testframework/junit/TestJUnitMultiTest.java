package adrninistrator.test.testframework.junit;

import adrninistrator.test.common.TestCommonUtil;
import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// JUnit在执行测试类的每个@Test方法前，都会执行测试类的无参数构造方法，创建新的实例
public class TestJUnitMultiTest {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitMultiTest.class);

    private static int instanceNum = 0;

    private static int lastHashCode = 0;

    public TestJUnitMultiTest() {
        instanceNum++;
        logger.info("TestJUnitMultiTest: {}", instanceNum);
    }

    @Test
    public void test1() {
        doTest("test1");
    }

    @Test
    public void test2() {
        doTest("test2");
    }

    @Test
    public void test3() {
        doTest("test3");
    }

    @AfterClass
    public static void afterClass() {
        assertEquals(instanceNum, TestCommonUtil.getTestNum(TestJUnitMultiTest.class));
    }

    private void doTest(String methodName) {
        int hashCode = System.identityHashCode(this);

        logger.info("{} hashCode: {}, lastHashCode: {}", methodName, hashCode, lastHashCode);

        if (lastHashCode != 0) {
            assertNotEquals(lastHashCode, hashCode);
        }

        lastHashCode = hashCode;
    }
}
