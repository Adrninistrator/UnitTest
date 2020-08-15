package com.adrninistrator.service.impl;

import com.adrninistrator.common.annotation.TestAopAnnotation;
import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestAOPAnnotationService1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
    在以下类中设置AOP处理
    TestAOPAspectAnnotation1
 */
@Service
public class TestAOPAnnotationService1Impl implements TestAOPAnnotationService1 {

    private static final Logger logger = LoggerFactory.getLogger(TestAOPAnnotationService1Impl.class);

    @TestAopAnnotation
    @Override
    public String testAround(String str) {
        logger.info("testAround");

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }
}
