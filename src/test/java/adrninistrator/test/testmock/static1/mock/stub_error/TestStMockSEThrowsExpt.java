package adrninistrator.test.testmock.static1.mock.stub_error;

import adrninistrator.test.testmock.base.TestMockNoSpBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid2;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@PrepareForTest({TestStaticPublicNonVoid2.class})
public class TestStMockSEThrowsExpt extends TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStMockSEThrowsExpt.class);

    /*
        使用PowerMockito.mockStatic方法对类进行Mock，且指定默认Answer抛出异常
        对于未被Stub的方法，会抛出指定异常
    */
    @Before
    public void init() {
        PowerMockito.mockStatic(TestStaticPublicNonVoid2.class, new ThrowsException(new RuntimeException(TestConstants.MOCKED)));

        assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid2.testString("")
        );

        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING);
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING));
    }

    @Test
    public void test1() {

        /*
            当使用PowerMockito.mockStatic方法对类进行Mock，指定默认Answer抛出异常时，使用Mockito.when()进行Stub会抛出异常
        */
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                Mockito.when(TestStaticPublicNonVoid2.testString(Mockito.anyString()))
        );
        logger.error("error: ", exception);
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test2() {
        /*
            使用Mockito.when().then...()对静态公有非void方法进行Stub时，可以分解为以下三步
            执行真实方法，参数使用Stub条件，获取返回值
            针对返回值执行Mockito.when()方法，获得OngoingStubbing对象
            调用OngoingStubbing的then...方法，设置Stub操作

            当执行PowerMockito.mockStatic方法指定默认Answer抛出异常时，以上执行真实方法的步骤会抛出异常
        */
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid2.testString(Mockito.anyString())
        );

        logger.error("error: ", exception);
        assertEquals(TestConstants.MOCKED, exception.getMessage());
    }

    @Test
    public void test3() throws Exception {

        // 当使用PowerMockito.mockStatic方法对类进行Mock，指定默认Answer抛出异常时，进行Stub时应使用PowerMockito.doxxx().when()方法
        PowerMockito.doReturn(TestConstants.MOCKED).when(TestStaticPublicNonVoid2.class, TestStaticPublicNonVoid2.NAME_TESTSTRING,
                Mockito.anyString());

        String result = TestStaticPublicNonVoid2.testString("");
        assertEquals(TestConstants.MOCKED, result);
    }
}
