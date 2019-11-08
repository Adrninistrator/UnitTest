package com.test.aspect;

import com.test.common.TestConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class TestAOPAspect1 {

    private static final Logger logger = LoggerFactory.getLogger(TestAOPAspect1.class);

    public static final String NAME_CHECK = "check";

    @Around("execution(* com.test.service.TestAOPService1.testAround(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("around-before");

        if (!check(joinPoint.getArgs())) {

            logger.info("check not pass");

            return TestConstants.MINUS;
        }

        logger.info("around-after");

        return joinPoint.proceed();
    }

    private boolean check(Object[] args) {

        logger.info("check: {}", Arrays.toString(args));

        String arg1 = (String) args[0];

        return TestConstants.FLAG1.equals(arg1);
    }
}
