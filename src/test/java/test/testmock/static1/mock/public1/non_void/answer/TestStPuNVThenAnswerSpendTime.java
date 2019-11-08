package test.testmock.static1.mock.public1.non_void.answer;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.common.TestCommonUtil;
import test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;

//延长方法执行耗时
public class TestStPuNVThenAnswerSpendTime extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenAnswerSpendTime.class);

    private static final long SLEEP_TIME = 2000L;

    @Test
    public void test1() {

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenAnswer
                (new TestAnswer());

        long startTime = System.currentTimeMillis();

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        //返回值应为真实方法返回值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        long spendTime = System.currentTimeMillis() - startTime;

        logger.info("spendTime: {}", spendTime);

        //执行时间应较快
        Assert.assertTrue(spendTime < SLEEP_TIME / 2);
    }

    @Test
    public void test2() {

        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenAnswer
                (new TestAnswer());

        long startTime = System.currentTimeMillis();

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        //返回值应为真实方法返回值
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        long spendTime = System.currentTimeMillis() - startTime;

        logger.info("spendTime: {}", spendTime);

        //执行时间包含等待时间
        Assert.assertTrue(spendTime > SLEEP_TIME / 2);
    }

    static class TestAnswer implements Answer<String> {

        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {

            String arg1 = TestCommonUtil.getMockArg(invocation, 0, String.class);

            if (TestConstants.FLAG1.equals(arg1)) {
                Thread.sleep(SLEEP_TIME);
            }

            return (String) invocation.callRealMethod();
        }
    }
}
