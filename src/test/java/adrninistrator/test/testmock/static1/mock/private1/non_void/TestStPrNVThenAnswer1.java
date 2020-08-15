package adrninistrator.test.testmock.static1.mock.private1.non_void;

import adrninistrator.test.testmock.static1.mock.private1.non_void.answer.AnswerStaticPrivateNonVoid1;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPrivateNonVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

// 使用Answer实现回调
public class TestStPrNVThenAnswer1 extends TestStaticPrivateNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrNVThenAnswer1.class);

    // 通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1);

        // 创建Answer，指定预期标志为TestConstants.FLAG3
        AnswerStaticPrivateNonVoid1 answerStaticPrivateNonVoid1 = new AnswerStaticPrivateNonVoid1(TestConstants.FLAG3);

        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito.anyString(),
                Mockito.any(TestTableEntity.class)).thenAnswer(answerStaticPrivateNonVoid1);

        TestTableEntity testTableEntity1 = new TestTableEntity();
        testTableEntity1.setFlag(TestConstants.FLAG1);

        // 通过反射执行私有方法，参数2 TestTableEntity的flag设置为TestConstants.FLAG1
        String str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, "",
                testTableEntity1);
        logger.info("TestStaticPrivateNonVoid1.test1(\"\", testTableEntity1) thenAnswer: {}", str);
        // 返回值应为AnswerStaticPrivateNonVoid1中设置的TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1, str);

        // 之前调用TestStaticPrivateNonVoid1.test1方法，参数1不是TestConstants.FLAG3，AnswerStaticPrivateNonVoid1的called标志应为false
        assertFalse(answerStaticPrivateNonVoid1.isCalled());

        // 通过反射执行私有方法，参数1设置为TestConstants.FLAG3，参数2 TestTableEntity的flag设置为null
        str = Whitebox.invokeMethod(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1,
                TestConstants.FLAG3, new TestTableEntity());
        logger.info("TestStaticPrivateNonVoid1.test1(TestConstants.FLAG3, new TestTableEntity()) thenAnswer: {}", str);
        // 返回值应为AnswerStaticPrivateNonVoid1中设置的固定值TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, str);

        // 前一次调用TestStaticPrivateNonVoid1.test1方法，参数1是TestConstants.FLAG3，AnswerStaticPrivateNonVoid1的called标志应为true
        assertTrue(answerStaticPrivateNonVoid1.isCalled());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }

    // 通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1);

        // 创建Answer，指定预期标志为TestConstants.FLAG3
        AnswerStaticPrivateNonVoid1 answerStaticPrivateNonVoid1 = new AnswerStaticPrivateNonVoid1(TestConstants.FLAG3);

        // 指定公有方法执行真实方法
        Mockito.when(TestStaticPrivateNonVoid1.testPublic1(Mockito.anyString(), Mockito.any(TestTableEntity.class)))
                .thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateNonVoid1.class, TestStaticPrivateNonVoid1.NAME_TEST1, Mockito.anyString(),
                Mockito.any(TestTableEntity.class)).thenAnswer(answerStaticPrivateNonVoid1);

        TestTableEntity testTableEntity1 = new TestTableEntity();
        testTableEntity1.setFlag(TestConstants.FLAG1);

        // 通过公有方法执行私有方法，参数2 TestTableEntity的flag设置为TestConstants.FLAG1
        String str = TestStaticPrivateNonVoid1.testPublic1("", testTableEntity1);
        logger.info("TestStaticPrivateNonVoid1.testPublic1(\"\", testTableEntity1) thenAnswer: {}", str);
        // 返回值应为AnswerStaticPrivateNonVoid1中设置的TestConstants.FLAG1
        assertEquals(TestConstants.FLAG1, str);

        // 之前调用TestStaticPrivateNonVoid1.test1方法，参数1不是TestConstants.FLAG3，AnswerStaticPrivateNonVoid1的called标志应为false
        assertFalse(answerStaticPrivateNonVoid1.isCalled());

        // 通过公有方法执行私有方法，参数1设置为TestConstants.FLAG3，参数2 TestTableEntity的flag设置为null
        str = TestStaticPrivateNonVoid1.testPublic1(TestConstants.FLAG3, new TestTableEntity());
        logger.info("TestStaticPrivateNonVoid1.testPublic1(TestConstants.FLAG3, new TestTableEntity()) thenAnswer: " +
                "{}", str);
        // 返回值应为AnswerStaticPrivateNonVoid1中设置的固定值TestConstants.MOCKED
        assertEquals(TestConstants.MOCKED, str);

        // 前一次调用TestStaticPrivateNonVoid1.test1方法，参数1是TestConstants.FLAG3，AnswerStaticPrivateNonVoid1的called标志应为true
        assertTrue(answerStaticPrivateNonVoid1.isCalled());

        // 真实方法未执行
        assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateNonVoid1.class,
                TestStaticPrivateNonVoid1.NAME_TEST1));
    }
}
