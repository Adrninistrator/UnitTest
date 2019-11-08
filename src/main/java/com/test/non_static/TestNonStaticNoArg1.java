package com.test.non_static;

import com.test.common.TestConstants;
import com.test.util.TestCallTimesUtil;

public class TestNonStaticNoArg1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";

    private String flag;

    public TestNonStaticNoArg1() {

        TestCallTimesUtil.addCallTimes();

        flag = TestConstants.FLAG1;
    }

    public String test1() {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    public String test2(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    public String getFlag() {
        return flag;
    }
}
