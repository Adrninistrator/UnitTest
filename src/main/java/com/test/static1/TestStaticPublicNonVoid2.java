package com.test.static1;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.util.TestCallTimesUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestStaticPublicNonVoid2 {

    public static String testString(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    public static StringBuffer testStringBuffer(String str) {

        TestCallTimesUtil.addCallTimes();

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(TestConstants.NOT_MOCKED);

        return stringBuffer;
    }

    public static StringBuilder testStringBuilder(String str) {

        TestCallTimesUtil.addCallTimes();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(TestConstants.NOT_MOCKED);

        return stringBuilder;
    }

    public static byte testByteLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_BYTE;
    }

    public static Byte testByteUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Byte.valueOf(TestConstants.DEFAULT_BYTE);
    }

    public static char testCharLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_CHAR;
    }

    public static Character testCharUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Character.valueOf(TestConstants.DEFAULT_CHAR);
    }

    public static boolean testBooleanLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_BOOL;
    }

    public static Boolean testBooleanUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Boolean.valueOf(TestConstants.DEFAULT_BOOL);
    }

    public static short testShortLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_SHORT;
    }

    public static Short testShortUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Short.valueOf(TestConstants.DEFAULT_SHORT);
    }

    public static int testInt(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_INT;
    }

    public static Integer testInteger(String str) {

        TestCallTimesUtil.addCallTimes();

        return Integer.valueOf(TestConstants.DEFAULT_INT);
    }

    public static long testLongLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_LONG;
    }

    public static Long testLongUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Long.valueOf(TestConstants.DEFAULT_LONG);
    }

    public static float testFloatLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_FLOAT;
    }

    public static Float testFloatUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Float.valueOf(TestConstants.DEFAULT_FLOAT);
    }

    public static double testDoubleLower(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_DOUBLE;
    }

    public static Double testDoubleUpper(String str) {

        TestCallTimesUtil.addCallTimes();

        return Double.valueOf(TestConstants.DEFAULT_DOUBLE);
    }

    public static BigDecimal testBigDecimal(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.DEFAULT_BIGDECIMAL;
    }

    public static TestTableEntity testTestTableEntity(String str) {

        TestCallTimesUtil.addCallTimes();

        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setFlag(TestConstants.FLAG1);

        return testTableEntity;
    }

    public static List testList(String str) {

        TestCallTimesUtil.addCallTimes();

        List<String> list = new LinkedList();
        list.add(TestConstants.NOT_MOCKED);

        return list;
    }

    public static Map testMap(String str) {

        TestCallTimesUtil.addCallTimes();

        Map<String, String> map = new HashMap(1);
        map.put(TestConstants.NOT_MOCKED, TestConstants.NOT_MOCKED);

        return map;
    }
}
