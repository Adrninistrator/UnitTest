package test.testframework.junit.expt;

import com.test.common.TestConstants;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    expected属性只能检查异常的类，无法检查异常信息。当需要检查异常信息时，可在代码中通过try-catch捕获异常，检查异常信息后再抛出异常。
    当出现异常后，后续代码不会继续执行。
 */
public class TestJUnitException1 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitException1.class);

    private static boolean flag = false;

    //应出现expected指定异常
    @Test(expected = RuntimeException.class)
    public void test1() {

        testException();

        flag = true;
    }

    //应出现expected指定异常
    @Test(expected = RuntimeException.class)
    public void test2() {

        try {
            testException();
        } catch (RuntimeException e) {

            logger.info("error: {}", e);

            Assert.assertEquals(TestConstants.MOCKED, e.getMessage());

            throw e;
        }

        flag = true;
    }

    //应出现expected指定异常
    @Test(expected = AssertionError.class)
    public void test3() {

        try {
            Assert.fail(TestConstants.MOCKED);
        } catch (AssertionError e) {

            logger.info("error: {}", e);

            Assert.assertEquals(TestConstants.MOCKED, e.getMessage());

            throw e;
        }

        flag = true;
    }

    @AfterClass
    public static void afterClass() {
        //当出现异常后，后续代码不会继续执行
        Assert.assertFalse(flag);
    }

    private void testException() {

        throw new RuntimeException(TestConstants.MOCKED);
    }
}
