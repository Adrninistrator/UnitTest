package adrninistrator.test.testmock.static1.mock.public1.non_void.test_answer;

import adrninistrator.test.testmock.static1.mock.public1.non_void.TestStaticPublicNonVoidBase;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.static1.TestStaticPublicNonVoid1;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// 延长方法执行耗时
public class TestStPuNVThenAnswerSpendTime extends TestStaticPublicNonVoidBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStPuNVThenAnswerSpendTime.class);

    private static final long SLEEP_TIME = 2000L;

    @Test
    public void test1() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenAnswer
                (new TestAnswer());

        long startTime = System.currentTimeMillis();

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);

        long spendTime = System.currentTimeMillis() - startTime;

        logger.info("spendTime: {}", spendTime);

        // 执行时间应较快
        assertTrue(spendTime < SLEEP_TIME / 2);
    }

    @Test
    public void test2() {
        Mockito.when(TestStaticPublicNonVoid1.test1(Mockito.anyString(), Mockito.any(TestTableEntity.class))).thenAnswer
                (new TestAnswer());

        long startTime = System.currentTimeMillis();

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        // 返回值应为真实方法返回值
        assertEquals(TestConstants.NOT_MOCKED, str);

        long spendTime = System.currentTimeMillis() - startTime;

        logger.info("spendTime: {}", spendTime);

        // 执行时间包含等待时间
        assertTrue(spendTime > SLEEP_TIME / 2);
    }

    static class TestAnswer implements Answer<String> {

        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {

            String arg1 = invocation.getArgument(0);

            if (TestConstants.FLAG1.equals(arg1)) {
                Thread.sleep(SLEEP_TIME);
            }

            return (String) invocation.callRealMethod();
        }
    }
}
