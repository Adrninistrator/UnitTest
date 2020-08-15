package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// 根据请求参数决定修改返回值、抛出异常或执行真实方法
public class TestStPuNVThenAnswerModifyRsp1 extends TestStaticPublicNonVoidBase {

    @Before
    public void init() {
        Mockito.when(TestStaticPublicNonVoid1.test4(Mockito.anyString())).thenAnswer(invocation -> {

                    String arg1 = invocation.getArgument(0);

                    if (TestConstants.FLAG1.equals(arg1)) {
                        return TestConstants.FLAG1;
                    } else if (TestConstants.FLAG2.equals(arg1)) {
                        throw new RuntimeException(TestConstants.MOCKED);
                    } else if (TestConstants.FLAG3.equals(arg1)) {
                        // 调用真实方法
                        return invocation.callRealMethod();
                    }

                    return TestConstants.MOCKED;
                }
        );
    }

    @Test
    public void test1() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG1);

        // 返回值应为TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1, str);

        // 真实方法应未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }

    @Test
    public void test2() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                TestStaticPublicNonVoid1.test4(TestConstants.FLAG2)
        );
        assertEquals(TestConstants.MOCKED, exception.getMessage());

        // 真实方法应未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }

    @Test
    public void test3() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        String str = TestStaticPublicNonVoid1.test4(TestConstants.FLAG3);
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.FLAG3 + TestConstants.MINUS, str);

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }

    @Test
    public void test4() {
        TestCallTimesUtil.clearCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4);

        String str = TestStaticPublicNonVoid1.test4(TestConstants.MINUS);
        // 返回值应为TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, str);

        // 真实方法应未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicNonVoid1.class,
                TestStaticPublicNonVoid1.NAME_TEST4));
    }
}
