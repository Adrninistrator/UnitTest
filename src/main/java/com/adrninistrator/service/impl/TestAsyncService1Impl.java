package com.adrninistrator.service.impl;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAsyncService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestAsyncService1Impl implements TestAsyncService1 {

    private static final Logger logger = LoggerFactory.getLogger(TestAsyncService1Impl.class);

    @Override
    public String test1(String str) {
        logger.info("test1");

        async(str);

        return TestConstants.NOT_MOCKED;
    }

    @Async
    @Override
    public String async(String str) {
        logger.info("async");
        return TestConstants.NOT_MOCKED;
    }
}
