package com.test.static1;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.util.TestCallTimesUtil;

import java.io.FileNotFoundException;

public class TestStaticPublicNonVoid1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";
    public static final String NAME_TEST4 = "test4";
    public static final String NAME_GETFLAG = "getFlag";

    public static String flag = "flag";

    public static String test1(String str, TestTableEntity testTableEntity) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    public static String test2(String str) throws FileNotFoundException {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    public static String test3() {

        return TestConstants.NOT_MOCKED;
    }

    public static String test4(String str) {

        TestCallTimesUtil.addCallTimes();

        return str + TestConstants.MINUS;
    }

    public static String test5(TestTableEntity testTableEntity) {

        return testTableEntity.getId() + TestConstants.MINUS;
    }

    public static String test6(int i, String str, TestTableEntity testTableEntity) {

        return TestConstants.NOT_MOCKED;
    }

    public static int test7(Integer integer) {

        return integer.intValue();
    }

    public static String test8(String str, Object[] objects) {

        return TestConstants.NOT_MOCKED;
    }

    public static String test9(Integer integer) {

        return TestConstants.NOT_MOCKED;
    }

    public static String getFlag() {

        TestCallTimesUtil.addCallTimes();

        return flag;
    }

    public static String getFlag2() {
        return TestConstants.MINUS + flag;
    }
}
