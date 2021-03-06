package com.adrninistrator.non_static;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.util.TestCallTimesUtil;

public class TestNonStaticSingleton1 {

    public static final String NAME_TEST1 = "test1";

    private static volatile TestNonStaticSingleton1 instance;

    public static TestNonStaticSingleton1 getInstance() {
        TestCallTimesUtil.addCallTimes();

        if (instance == null) {
            synchronized (TestNonStaticSingleton1.class) {
                if (instance == null) {
                    instance = new TestNonStaticSingleton1();
                }
            }
        }
        return instance;
    }

    private TestNonStaticSingleton1() {
        throw new IllegalStateException("illegal");
    }

    public String test1() {
        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }
}
