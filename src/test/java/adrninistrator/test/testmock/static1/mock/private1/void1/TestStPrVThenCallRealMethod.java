package adrninistrator.test.testmock.static1.mock.private1.void1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

// 执行真实方法，Stub条件使用Mockito.any(StringBuilder.class)
public class TestStPrVThenCallRealMethod extends TestStaticPrivateVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrVThenCallRealMethod.class);

    // 通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenCallRealMethod();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG1);

        // 执行TestStaticPrivateVoid1.test1
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuilder);
        // 执行TestStaticPrivateVoid1.test1方法，满足thenCallRealMethod的参数条件，调用参数应为真实方法处理后的值
        logger.info("TestStaticPrivateVoid1.test1 (TestConstants.FLAG1) thenCallRealMethod: {}", stringBuilder);
        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, stringBuilder.toString());

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }

    // 通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        // 指定公有方法执行真实方法
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TESTPUBLIC1, Mockito.any
                (StringBuilder.class)).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenCallRealMethod();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG1);

        // 执行TestStaticPrivateVoid1.test1
        TestStaticPrivateVoid1.testPublic1(stringBuilder);
        // 执行TestStaticPrivateVoid1.testPublic1方法，满足thenCallRealMethod的参数条件，调用参数应为真实方法处理后的值
        logger.info("TestStaticPrivateVoid1.testPublic1 (TestConstants.FLAG1) thenCallRealMethod: {}", stringBuilder);
        assertEquals(TestConstants.FLAG1 + TestConstants.MINUS, stringBuilder.toString());

        // 真实方法执行1次
        assertEquals(1, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }


}
