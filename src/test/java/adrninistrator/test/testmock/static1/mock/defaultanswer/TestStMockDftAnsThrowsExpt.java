package adrninistrator.test.testmock.static1.mock.defaultanswer;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/*
    使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer抛出异常
    对于未被Stub的方法，会抛出指定异常
*/
@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockDftAnsThrowsExpt extends TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStMockDftAnsThrowsExpt.class);

    @Before
    public void init() {
        // 对TestStaticPublicNonVoid2类进行Mock，默认Answer使用ThrowsException，即执行方法时会抛出指定异常
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, new ThrowsException(new RuntimeException(TestConstants.MOCKED)));
    }

    @Test
    public void test() {
        testString();
        testStringBuffer();
        testStringBuilder();
    }

    private void testString() {

        // 当执行TestStaticPublicNonVoid2类的方法时，会抛出指定的异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid2.testString("")
        );
        logger.error("error: ", exception);
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    private void testStringBuffer() {
        // 当执行TestStaticPublicNonVoid2类的方法时，会抛出指定的异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid2.testStringBuffer("")
        );
        logger.error("error: ", exception);
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    private void testStringBuilder() {
        // 当执行TestStaticPublicNonVoid2类的方法时，会抛出指定的异常
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid2.testStringBuilder("")
        );
        logger.error("error: ", exception);
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }
}
