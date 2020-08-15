package adrninistrator.test.other;

import adrninistrator.test.testframework.spring.base.TestSpringBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// 等待被测试代码执行完毕，再执行后续的检查操作
public class TestThread extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestThread.class);

    @Resource(name = "testThreadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private boolean called = false;

    private void testOper() {
        threadPoolTaskExecutor.execute(() -> {
            try {
                Thread.sleep(2000L);

                called = true;
            } catch (InterruptedException e) {
                logger.info("error: ", e);
                Thread.currentThread().interrupt();
            }
        });
    }

    @Test
    public void test() throws InterruptedException {

        testOper();

        assertFalse(called);

        while (threadPoolTaskExecutor.getActiveCount() > 0) {
            logger.info("threadPoolTaskExecutor.getActiveCount()>0");

            Thread.sleep(200L);
        }

        assertTrue(called);
    }
}
