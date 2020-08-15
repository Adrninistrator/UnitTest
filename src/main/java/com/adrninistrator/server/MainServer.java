package com.adrninistrator.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainServer {

    private static final Logger logger = LoggerFactory.getLogger(MainServer.class);

    private static final String APPLICTION_LOCATION = "classpath:applicationContext.xml";

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
            context.setConfigLocation(APPLICTION_LOCATION);
            context.refresh();
            context.start();

            Thread.sleep(2000L);

            context.close();
        } catch (Exception e) {
            logger.error("error ", e);
        }
    }
}
