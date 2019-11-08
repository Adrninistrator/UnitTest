package com.test.static1;

import com.test.common.TestConstants;
import com.test.util.TestCallTimesUtil;

public class TestStaticPrivateVoid1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TESTPUBLIC1 = "testPublic1";

    private static void test1(StringBuffer stringBuffer) {

        TestCallTimesUtil.addCallTimes();

        stringBuffer.append(TestConstants.MINUS);
    }

    public static void testPublic1(StringBuffer stringBuffer) {

        test1(stringBuffer);
    }

}
