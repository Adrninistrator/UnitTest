package adrninistrator.test.testmock.static1.mock.public1.void1;

import adrninistrator.test.testmock.static1.mock.public1.void1.answer.AnswerStaticPublicVoid1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

// 使用Answer实现回调
public class TestStPuVThenAnswer extends TestStaticPublicVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuVThenAnswer.class);

    @Test
    public void test() throws Exception {

        AnswerStaticPublicVoid1 answerStaticPublicVoid1 = new AnswerStaticPublicVoid1(TestStPuVThenAnswer.class
                .getName() + ".test(");

        PowerMockito.when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any(StringBuilder
                .class)).thenAnswer(answerStaticPublicVoid1);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG1);
        // 执行TestStaticPublicVoid1.test1方法，参数1设置为TestConstants.FLAG1
        TestStaticPublicVoid1.test1(stringBuilder);
        logger.info("TestStaticPublicVoid1.test1 thenAnswer TestConstants.FLAG1: {}", stringBuilder);
        // 返回值应为AnswerStaticPublicVoid1中设置的TestConstants.FLAG1+TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1, stringBuilder.toString());

        // 之前调用TestStaticPublicVoid1.test1方法，参数1不是TestConstants.FLAG3，AnswerStaticPublicVoid1的called标志应为false
        assertFalse(answerStaticPublicVoid1.isCalled());

        stringBuilder.setLength(0);
        stringBuilder.append(TestConstants.FLAG3);
        // 执行TestStaticPublicVoid1.test1方法，参数1设置为TestConstants.FLAG3
        TestStaticPublicVoid1.test1(stringBuilder);
        logger.info("TestStaticPublicVoid1.test1 thenAnswer TestConstants.FLAG3: {}", stringBuilder);
        // 返回值应为AnswerStaticPublicVoid1中设置的固定值TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, stringBuilder.toString());

        // 前一次调用TestStaticPublicVoid1.test1方法，参数1是TestConstants.FLAG3，AnswerStaticPublicVoid1的called标志应为true
        assertTrue(answerStaticPublicVoid1.isCalled());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
