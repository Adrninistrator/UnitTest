package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.Location;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 根据调用方法信息决定修改返回值、抛出异常或执行真实方法
public class TestStPuNVThenAnswerGetLctMdfRsp1 extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenAnswerGetLctMdfRsp1.class);

    @Before
    public void init() {
        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenAnswer(invocation -> {

            // 获取调用方法的代码信息
            Location location = Whitebox.getInternalState(invocation, Location.class);

            String locationStr = location.toString();

            logger.info("location: {}", locationStr);

            if (locationStr.contains(TestStPuNVThenAnswerGetLctMdfRsp1.class.getName() + ".test1")) {
                // test1调用该方法时的处理

                return TestConstants.MOCKED;
            } else if (locationStr.contains(TestStPuNVThenAnswerGetLctMdfRsp1.class.getName()) && locationStr.contains("test2")) {
                // test2调用该方法时的处理

                throw new RuntimeException(TestConstants.MOCKED);
            } else if (locationStr.contains(TestStPuNVThenAnswerGetLctMdfRsp1.class.getName() + ".test3")) {
                // test3调用该方法时的处理

                return (String) invocation.callRealMethod();
            }

            return TestConstants.MOCKED;
        });
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        // 返回值应为TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid1.test4(TestConstants.FLAG1)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }

    @Test
    public void test3() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, str);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }

    @Test
    public void test4() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);
        // 返回值应为TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }
}
