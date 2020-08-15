package com.adrninistrator.spring;

import com.adrninistrator.common.constants.TestFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * created by Adrninistrator on 2020/4/21
 * description:
 */

@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(TestBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("BeanFactoryPostProcessor.postProcessBeanFactory");

        boolean setLazy;

        if (Boolean.TRUE.equals(TestFlag.isAllLazy())) {
            // TestFlag.isAllLazy()为Boolean.TRUE时，设置所有的Bean为懒加载
            setLazy = true;
        } else if (Boolean.FALSE.equals(TestFlag.isAllLazy())) {
            // TestFlag.isAllLazy()为Boolean.FALSE时，设置所有的Bean为非懒加载
            setLazy = false;
        } else {
            // TestFlag.isAllLazy()为null时（默认情况），退出
            return;
        }

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);

            beanDefinition.setLazyInit(setLazy);

            logger.info("beanClassName: {} lazy: {} setLazy: {}", beanDefinition.getBeanClassName(), beanDefinition.isLazyInit(), setLazy);
        }
    }
}
