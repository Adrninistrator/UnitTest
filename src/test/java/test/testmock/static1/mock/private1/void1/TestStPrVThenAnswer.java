package test.testmock.static1.mock.private1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPrivateVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//使用Answer实现回调
public class TestStPrVThenAnswer extends TestStaticPrivateVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPrVThenAnswer.class);

    //通过反射执行私有方法
    @Test
    public void test1() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        AnswerStaticPrivateVoid1 answerStaticPrivateVoid1 = new AnswerStaticPrivateVoid1();

        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenAnswer(answerStaticPrivateVoid1);

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG1);
        //执行TestStaticPrivateVoid1.test1方法，参数1设置为TestConstants.FLAG1
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuffer);
        logger.info("TestStaticPrivateVoid1.test1 thenAnswer TestConstants.FLAG1: {}", stringBuffer);
        //调用参数应为AnswerStaticPrivateVoid1中设置的TestConstants.FLAG1+TestConstants.FLAG1
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1, stringBuffer.toString());

        //之前调用TestStaticPrivateVoid1.test1方法，参数1不是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为false
        Assert.assertFalse(answerStaticPrivateVoid1.isCalled());

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG3);
        //执行TestStaticPrivateVoid1.test1方法，参数1设置为TestConstants.FLAG3
        Whitebox.invokeMethod(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, stringBuffer);
        logger.info("TestStaticPrivateVoid1.test1 thenAnswer TestConstants.FLAG3: {}", stringBuffer);
        //调用参数应为AnswerStaticPrivateVoid1中设置的固定值TestConstants.MOCKED
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        //前一次调用TestStaticPrivateVoid1.test1方法，参数1是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为true
        Assert.assertTrue(answerStaticPrivateVoid1.isCalled());

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }

    //通过公有方法执行私有方法
    @Test
    public void test2() throws Exception {

        TestCallTimesUtil.clearCallTimes(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1);

        AnswerStaticPrivateVoid1 answerStaticPrivateVoid1 = new AnswerStaticPrivateVoid1();

        //指定公有方法执行真实方法
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TESTPUBLIC1, Mockito.any
                (StringBuffer.class)).thenCallRealMethod();
        PowerMockito.when(TestStaticPrivateVoid1.class, TestStaticPrivateVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenAnswer(answerStaticPrivateVoid1);

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG1);
        //执行TestStaticPrivateVoid1.testPublic1方法，参数1设置为TestConstants.FLAG1
        TestStaticPrivateVoid1.testPublic1(stringBuffer);
        logger.info("TestStaticPrivateVoid1.testPublic1 thenAnswer TestConstants.FLAG1: {}", stringBuffer);
        //调用参数应为AnswerStaticPrivateVoid1中设置的TestConstants.FLAG1+TestConstants.FLAG1
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1, stringBuffer.toString());

        //之前调用TestStaticPrivateVoid1.testPublic1方法，参数1不是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为false
        Assert.assertFalse(answerStaticPrivateVoid1.isCalled());

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG3);
        //执行TestStaticPrivateVoid1.testPublic1方法，参数1设置为TestConstants.FLAG3
        TestStaticPrivateVoid1.testPublic1(stringBuffer);
        logger.info("TestStaticPrivateVoid1.testPublic1 thenAnswer TestConstants.FLAG3: {}", stringBuffer);
        //调用参数应为AnswerStaticPrivateVoid1中设置的固定值TestConstants.MOCKED
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        //前一次调用TestStaticPrivateVoid1.testPublic1方法，参数1是TestConstants.FLAG3，AnswerStaticPrivateVoid1的called标志应为true
        Assert.assertTrue(answerStaticPrivateVoid1.isCalled());

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPrivateVoid1.class,
                TestStaticPrivateVoid1.NAME_TEST1));
    }
}
