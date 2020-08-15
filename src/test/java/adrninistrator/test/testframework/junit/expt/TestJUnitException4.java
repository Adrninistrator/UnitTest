package adrninistrator.test.testframework.junit.expt;

import adrninistrator.test.common.TestMatcherExpClassEquals;
import com.adrninistrator.common.constants.TestConstants;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

// 测试assertThrows()方法检查异常信息
public class TestJUnitException4 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnitException4.class);

    @SuppressWarnings("deprecation")
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private static boolean flag1 = false;
    private static boolean flag2 = false;

    @AfterClass
    public static void afterClass() {
        assertTrue(flag1);
        assertTrue(flag2);
    }

    // 出现异常时进行检查
    @Test
    public void test1() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> throw1());

        assertEquals(TestConstants.FLAG1, exception.getMessage());

        // 使用assertThrows()检查异常时，若有异常发生，后续代码也会继续执行
        flag1 = true;

        logger.info("exception: ", exception);
    }

    // assertThrows()方法的参数1支持指定预期异常的父类
    @Test
    public void test2() {
        Exception exception = assertThrows(Exception.class, () -> throw1());

        assertTrue(exception instanceof RuntimeException);
        assertEquals(TestConstants.FLAG1, exception.getMessage());

        // 使用assertThrows()检查异常时，若有异常发生，后续代码也会继续执行
        flag2 = true;

        logger.info("exception: ", exception);
    }

    // 在使用assertThrows()时，若未出现异常，会抛出AssertionError异常
    @Test
    public void test3() {
        expectedException.expect(new TestMatcherExpClassEquals(AssertionError.class));

        assertThrows(RuntimeException.class, () -> doNothing());
    }

    // 在使用assertThrows()时，若实际出现的异常与预期不符，会抛出AssertionError异常
    @Test
    public void test4() {
        expectedException.expect(new TestMatcherExpClassEquals(AssertionError.class));

        assertThrows(FileNotFoundException.class, () -> doNothing());
    }

    private void doNothing() {
    }

    private void throw1() {
        throw new RuntimeException(TestConstants.FLAG1);
    }
}
