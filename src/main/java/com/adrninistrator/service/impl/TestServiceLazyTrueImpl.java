package com.adrninistrator.service.impl;

import com.adrninistrator.service.TestServiceLazyTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Lazy(value = true)
@Service
public class TestServiceLazyTrueImpl implements TestServiceLazyTrue, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceLazyTrueImpl.class);

    // 是否实例化标志
    private static AtomicBoolean inited = new AtomicBoolean(false);

    @Override
    public void test() {
        logger.info("test");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("TestServiceLazyTrueImpl.afterPropertiesSet");

        inited.set(true);
    }

    public static boolean isInited() {
        return inited.get();
    }

    // 重置是否实例化标志
    public static void reset() {
        inited.set(false);
    }
}