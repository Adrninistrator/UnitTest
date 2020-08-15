package com.adrninistrator.aspect;

import com.adrninistrator.common.constants.TestConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class TestAOPAspectAnnotation1 {

    private static final Logger logger = LoggerFactory.getLogger(TestAOPAspectAnnotation1.class);

    @Around("@annotation(com.adrninistrator.common.annotation.TestAopAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        logger.info("around-before {}", Arrays.toString(args));

        Object obj = joinPoint.proceed();

        logger.info("around-after");

        if (obj instanceof String) {
            String rtn = (String) obj + TestConstants.MINUS;

            logger.info("around-after {}", rtn);

            return rtn;
        }

        logger.info("around-after {}", obj);

        return obj;
    }
}
