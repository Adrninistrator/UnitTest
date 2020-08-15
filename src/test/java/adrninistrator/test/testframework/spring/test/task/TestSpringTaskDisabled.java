package adrninistrator.test.testframework.spring.test.task;

import adrninistrator.test.testmock.base.TestMockBase;
import com.adrninistrator.scheduler.TestScheduler;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import static org.junit.Assert.assertEquals;

// 禁止Spring定时任务
@PrepareForTest({ScheduledTaskRegistrar.class})
public class TestSpringTaskDisabled extends TestMockBase {

    private static final Logger logger = LoggerFactory.getLogger(TestSpringTaskDisabled.class);

    @Autowired
    private TestScheduler testScheduler;

    @BeforeClass
    public static void beforeClass() {
        PowerMockito.suppress(PowerMockito.method(ScheduledTaskRegistrar.class, "scheduleTasks"));
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(20 * 1000L);

        int runTimes = testScheduler.getRunTimes();
        logger.info("testScheduler runTimes: {}", runTimes);

        // Spring定时任务执行次数应为0
        assertEquals(0, runTimes);
    }
}
