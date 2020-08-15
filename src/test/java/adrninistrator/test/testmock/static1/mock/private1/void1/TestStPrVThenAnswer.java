package adrninistrator.test.testmock.static1.mock.private1.void1;

import adrninistrator.test.testmock.static1.mock.private1.void1.answer.AnswerStaticPrivateVoid1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

// 使用Answer实现回调
public class TestStPrVThenAnswer extends TestStaticPrivateVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrVThenAnswer.class);

    // 通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        AnswerStaticPrivateVoid1 answerStaticPrivateVoid1 = new AnswerStaticPrivateVoid1();

        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenAnswer(answerStaticPrivateVoid1);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG1);
        // 执行TestStaticPrivateVoid1.test1方法，参数1设置为TestConstants.FLAG1
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuilder);
        logger.info("TestStaticPrivateVoid1.test1 thenAnswer TestConstants.FLAG1: {}", stringBuilder);
        // 调用参数应为AnswerStaticPrivateVoid1中设置的TestConstants.FLAG1+TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1, stringBuilder.toString());

        // 之前调用TestStaticPrivateVoid1.test1方法，参数1不是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为false
        assertFalse(answerStaticPrivateVoid1.isCalled());

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG3);
        // 执行TestStaticPrivateVoid1.test1方法，参数1设置为TestConstants.FLAG3
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuilder);
        logger.info("TestStaticPrivateVoid1.test1 thenAnswer TestConstants.FLAG3: {}", stringBuilder);
        // 调用参数应为AnswerStaticPrivateVoid1中设置的固定值TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        // 前一次调用TestStaticPrivateVoid1.test1方法，参数1是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为true
        assertTrue(answerStaticPrivateVoid1.isCalled());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }

    // 通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        AnswerStaticPrivateVoid1 answerStaticPrivateVoid1 = new AnswerStaticPrivateVoid1();

        // 指定公有方法执行真实方法
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TESTPUBLIC1, Mockito.any
                (StringBuilder.class)).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenAnswer(answerStaticPrivateVoid1);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG1);
        // 执行TestStaticPrivateVoid1.testPublic1方法，参数1设置为TestConstants.FLAG1
        TestStaticPrivateVoid1.testPublic1(stringBuilder);
        logger.info("TestStaticPrivateVoid1.testPublic1 thenAnswer TestConstants.FLAG1: {}", stringBuilder);
        // 调用参数应为AnswerStaticPrivateVoid1中设置的TestConstants.FLAG1+TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1, stringBuilder.toString());

        // 之前调用TestStaticPrivateVoid1.testPublic1方法，参数1不是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为false
        assertFalse(answerStaticPrivateVoid1.isCalled());

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG3);
        // 执行TestStaticPrivateVoid1.testPublic1方法，参数1设置为TestConstants.FLAG3
        TestStaticPrivateVoid1.testPublic1(stringBuilder);
        logger.info("TestStaticPrivateVoid1.testPublic1 thenAnswer TestConstants.FLAG3: {}", stringBuilder);
        // 调用参数应为AnswerStaticPrivateVoid1中设置的固定值TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        // 前一次调用TestStaticPrivateVoid1.testPublic1方法，参数1是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为true
        assertTrue(answerStaticPrivateVoid1.isCalled());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }
}
