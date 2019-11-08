package com.test.applicationlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationListener implements ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(TestApplicationListener.class);

    private long refreshEventHashCode;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("### ApplicationListener.onApplicationEvent: {} hashcode: {}", event.getClass().getSimpleName(),
                System.identityHashCode(event));

        if (event instanceof ContextRefreshedEvent) {

            refreshEventHashCode = System.identityHashCode(event);
        }
    }

    public long getRefreshEventHashCode() {
        return refreshEventHashCode;
    }
}
