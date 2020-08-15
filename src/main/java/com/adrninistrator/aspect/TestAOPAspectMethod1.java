package com.adrninistrator.aspect;

import com.adrninistrator.common.constants.TestConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class TestAOPAspectMethod1 {

    private static final Logger logger = LoggerFactory.getLogger(TestAOPAspectMethod1.class);

    public static final String NAME_CHECK = "check";

    @Around("execution(* com.adrninistrator.service.TestAOPService1.testAround(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("around-before");

        if (!check(joinPoint.getArgs())) {
            logger.info("check not pass");

            return TestConstants.MINUS;
        }

        Object obj = joinPoint.proceed();

        logger.info("around-after");

        return obj;
    }

    private boolean check(Object[] args) {
        logger.info("check: {}", Arrays.toString(args));

        String arg1 = (String) args[0];

        return TestConstants.FLAG1.equals(arg1);
    }
}
