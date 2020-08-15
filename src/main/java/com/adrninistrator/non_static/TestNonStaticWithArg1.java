package com.adrninistrator.non_static;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.util.TestCallTimesUtil;

public class TestNonStaticWithArg1 {

    public static final String NAME_TEST1 = "test1";

    private String str1;
    private String str2;

    private TestNonStaticWithArg1() {
        throw new IllegalStateException("illegal");
    }

    public TestNonStaticWithArg1(String str1) {
        this.str1 = str1;
        this.str2 = str1;
    }

    public TestNonStaticWithArg1(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String test1() {
        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }
}
