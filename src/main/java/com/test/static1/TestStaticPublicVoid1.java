package com.test.static1;

import com.test.common.TestConstants;
import com.test.util.TestCallTimesUtil;

public class TestStaticPublicVoid1 {

    public static final String NAME_TEST1 = "test1";

    public static void test1(StringBuffer stringBuffer) {

        TestCallTimesUtil.addCallTimes();

        stringBuffer.append(TestConstants.MINUS);
    }
}
