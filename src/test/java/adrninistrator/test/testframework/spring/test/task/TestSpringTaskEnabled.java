package adrninistrator.test.testframework.spring.test.task;

import adrninistrator.test.testframework.spring.base.TestSpringBase;
import com.adrninistrator.scheduler.TestScheduler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

// 不禁止Spring定时任务

// 使Spring Context重新加载，在执行类之前
@DirtiesContext(classMode = BEFORE_CLASS)
public class TestSpringTaskEnabled extends TestSpringBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringTaskEnabled.class);

    @Autowired
    private TestScheduler testScheduler;

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(20 * 1000L);

        int runTimes = testScheduler.getRunTimes();
        logger.info("testScheduler runTimes: {}", runTimes);

        // Spring定时任务执行次数应大于0
        assertTrue(runTimes > 0);
    }
}
