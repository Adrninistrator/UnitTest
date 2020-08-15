package com.adrninistrator.static1;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.util.TestCallTimesUtil;

public class TestStaticPrivateVoid1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TESTPUBLIC1 = "testPublic1";

    private static void test1(StringBuilder stringBuilder) {
        TestCallTimesUtil.addCallTimes();

        stringBuilder.append(TestConstants.MINUS);
    }

    public static void testPublic1(StringBuilder stringBuilder) {
        test1(stringBuilder);
    }

    private TestStaticPrivateVoid1() {
        throw new IllegalStateException("illegal");
    }
}
