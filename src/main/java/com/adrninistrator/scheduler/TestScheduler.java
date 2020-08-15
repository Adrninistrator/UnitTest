package com.adrninistrator.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component("com.adrninistrator.scheduler.TestScheduler")
public class TestScheduler {

    private static final Logger logger = LoggerFactory.getLogger(TestScheduler.class);

    private AtomicInteger runTimes = new AtomicInteger(0);

    public void test() {

        runTimes.incrementAndGet();

        logger.info("TestScheduler, runTimes: {}", runTimes.get());
    }

    public int getRunTimes() {
        return runTimes.get();
    }
}
