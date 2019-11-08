package test.testmock.static1.replace.public1.non_void;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.static1.TestStaticPublicNonVoid1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.testmock.base.TestMockNoSpBase;
import test.testmock.static1.mock.public1.non_void.answer.TestStPuNVThenAnswerSpendTime;

@PrepareForTest({TestStaticPublicNonVoid1.class})
public class TestStReplacePuNVSpendTime1 extends TestMockNoSpBase {

    private static final Logger logger = LoggerFactory.getLogger(TestStReplacePuNVSpendTime1.class);

    private static final long SLEEP_TIME = 2000L;

    @Before
    public void init() {

        PowerMockito.replace(PowerMockito.method(TestStaticPublicNonVoid1.class, TestStaticPublicNonVoid1.NAME_TEST1)
        ).with((proxy, method, args) -> {

            String arg1 = (String) args[0];

            if (TestConstants.FLAG1.equals(arg1)) {
                Thread.sleep(SLEEP_TIME);
            }

            return method.invoke(proxy, args);
        });
    }

    @Test
    public void test1() {

        long startTime = System.currentTimeMillis();

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG2, new TestTableEntity());
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        long spendTime = System.currentTimeMillis() - startTime;

        logger.info("spendTime: {}", spendTime);

        //执行时间应较快
        Assert.assertTrue(spendTime < SLEEP_TIME / 2);
    }

    @Test
    public void test2() {

        long startTime = System.currentTimeMillis();

        String str = TestStaticPublicNonVoid1.test1(TestConstants.FLAG1, new TestTableEntity());
        Assert.assertEquals(TestConstants.NOT_MOCKED, str);

        long spendTime = System.currentTimeMillis() - startTime;

        logger.info("spendTime: {}", spendTime);

        //执行时间应较快
        Assert.assertTrue(spendTime > SLEEP_TIME / 2);
    }
}
