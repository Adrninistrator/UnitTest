package com.test.static1;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.util.TestCallTimesUtil;

import java.io.FileNotFoundException;

public class TestStaticPrivateNonVoid1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";
    public static final String NAME_TEST3 = "test3";

    private static String test1(String str, TestTableEntity testTableEntity) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    private static String test2(String str) throws FileNotFoundException {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    private static String test3() {

        return TestConstants.NOT_MOCKED;
    }

    public static String testPublic1(String str, TestTableEntity testTableEntity) {

        TestCallTimesUtil.addCallTimes();

        return test1(str, testTableEntity);
    }

    public static String testPublic2(String str) throws FileNotFoundException {

        TestCallTimesUtil.addCallTimes();

        return test2(str);
    }

    public static String testPublic3() {

        TestCallTimesUtil.addCallTimes();

        return test3();
    }
}
