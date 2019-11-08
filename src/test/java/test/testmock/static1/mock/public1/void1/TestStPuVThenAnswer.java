package test.testmock.static1.mock.public1.void1;

import com.test.common.TestConstants;
import com.test.static1.TestStaticPublicVoid1;
import com.test.util.TestCallTimesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//使用Answer实现回调
public class TestStPuVThenAnswer extends TestStaticPublicVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuVThenAnswer.class);

    @Test
    public void test() throws Exception {

        AnswerStaticPublicVoid1 answerStaticPublicVoid1 = new AnswerStaticPublicVoid1(TestStPuVThenAnswer.class
                .getName() + ".test(");

        PowerMockito.when(TestStaticPublicVoid1.class, TestStaticPublicVoid1.NAME_TEST1, Mockito.any(StringBuffer
                .class)).thenAnswer(answerStaticPublicVoid1);

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG1);
        //执行TestStaticPublicVoid1.test1方法，参数1设置为TestConstants.FLAG1
        TestStaticPublicVoid1.test1(stringBuffer);
        logger.info("TestStaticPublicVoid1.test1 thenAnswer TestConstants.FLAG1: {}", stringBuffer);
        //返回值应为AnswerStaticPublicVoid1中设置的TestConstants.FLAG1+TestConstants.FLAG1
        Assert.assertEquals(TestConstants.FLAG1 + TestConstants.FLAG1, stringBuffer.toString());

        //之前调用TestStaticPublicVoid1.test1方法，参数1不是TestConstants.FLAG3，AnswerStaticPublicVoid1的called标志应为false
        Assert.assertFalse(answerStaticPublicVoid1.isCalled());

        stringBuffer.setLength(0);
        stringBuffer.append(TestConstants.FLAG3);
        //执行TestStaticPublicVoid1.test1方法，参数1设置为TestConstants.FLAG3
        TestStaticPublicVoid1.test1(stringBuffer);
        logger.info("TestStaticPublicVoid1.test1 thenAnswer TestConstants.FLAG3: {}", stringBuffer);
        //返回值应为AnswerStaticPublicVoid1中设置的固定值TestConstants.MOCKED
        Assert.assertEquals(TestConstants.MOCKED, stringBuffer.toString());

        //前一次调用TestStaticPublicVoid1.test1方法，参数1是TestConstants.FLAG3，AnswerStaticPublicVoid1的called标志应为true
        Assert.assertTrue(answerStaticPublicVoid1.isCalled());

        //真实方法应未被执行过
        Assert.assertEquals(0, TestCallTimesUtil.getCallTimes(TestStaticPublicVoid1.class,
                TestStaticPublicVoid1.NAME_TEST1));
    }
}
