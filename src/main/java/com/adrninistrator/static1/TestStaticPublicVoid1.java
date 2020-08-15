package com.adrninistrator.static1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.util.TestCallTimesUtil;

public class TestStaticPublicVoid1 {

    public static final String NAME_TEST1 = "test1";

    public static void test1(StringBuilder stringBuilder) {
        TestCallTimesUtil.addCallTimes();

        stringBuilder.append(TestConstants.MINUS);
    }

    private TestStaticPublicVoid1() {
        throw new IllegalStateException("illegal");
    }
}
