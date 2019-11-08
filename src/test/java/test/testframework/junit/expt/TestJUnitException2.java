package test.testframework.junit.expt;

import com.test.common.TestConstants;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
    当出现异常后，后续代码不会继续执行。
    假如需要在出现异常后，继续执行后续代码时，可在代码中通过try-catch对可能出现异常的代码进行捕获，进行后续处理后再抛出异常。
 */
public class TestJUnitException2 {

    private static boolean flag1 = false;
    private static boolean flag2a = false;
    private static boolean flag2b = false;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @AfterClass
    public static void afterClass() {

        Assert.assertFalse(flag1);
        Assert.assertTrue(flag2a);
        Assert.assertFalse(flag2b);
    }

    @Test
    public void test1() {

        //应出现指定异常
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        testException();

        //使用ExpectedException，当异常发生后，后续代码不会执行
        flag1 = true;
    }

    @Test
    public void test2() {

        //应出现指定异常
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(TestConstants.MOCKED);

        try {

            testException();
        } catch (Exception e) {

            //当使用ExpectedException检查需要出现指定异常，且需要进行后续处理时，可先在catch中先进行后续处理，再抛出异常
            flag2a = true;

            throw e;
        }

        //使用ExpectedException，当异常发生后，后续代码不会执行
        flag2b = true;
    }

    private void testException() {

        throw new RuntimeException(TestConstants.MOCKED);
    }
}
