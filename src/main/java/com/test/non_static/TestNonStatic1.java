package com.test.non_static;

import com.test.common.TestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestNonStatic1 {

    private static final Logger logger = LoggerFactory.getLogger(TestNonStatic1.class);

    private String str1 = "str1";
    private String str2 = "str2";

    private TestNonStaticNoArg1 testNonStaticNoArg1 = null;

    public String getValue() {

        return str1 + TestConstants.MINUS + str2;
    }

    public TestNonStaticNoArg1 test1() {

        Thread thread = new Thread(() -> testNonStaticNoArg1 = new TestNonStaticNoArg1());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            logger.error("error: ", e);
        }

        return testNonStaticNoArg1;
    }

    public TestNonStaticNoArg1 test2() {

        return new TestNonStatic1Inner().test1();
    }

    private class TestNonStatic1Inner {

        private TestNonStaticNoArg1 test1() {
            return new TestNonStaticNoArg1();
        }
    }
}
