package com.adrninistrator.spring;

import com.adrninistrator.common.constants.TestFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by Adrninistrator on 2019/3/30
 * description:
 */

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(TestBeanPostProcessor.class);

    // 记录完成初始化的Bean数量
    private static AtomicInteger inited = new AtomicInteger(0);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (TestFlag.isAllLazy() == null) {
            return bean;
        }

        logger.info("postProcessBeforeInitialization : {} {}", beanName, bean.getClass().getName());

        inited.incrementAndGet();

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public static int getInitedNum() {
        return inited.get();
    }
}
