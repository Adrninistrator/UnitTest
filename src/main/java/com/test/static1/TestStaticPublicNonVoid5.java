package com.test.static1;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestStaticPublicNonVoid5 {

    private static String string = TestConstants.NOT_MOCKED;
    private static StringBuffer stringBuffer = new StringBuffer().append(TestConstants.NOT_MOCKED);
    private static StringBuilder stringBuilder = new StringBuilder().append(TestConstants.NOT_MOCKED);
    private static byte byteLower = TestConstants.DEFAULT_BYTE;
    private static Byte byteUpper = Byte.valueOf(TestConstants.DEFAULT_BYTE);
    private static char charLower = TestConstants.DEFAULT_CHAR;
    private static Character charUpper = Character.valueOf(TestConstants.DEFAULT_CHAR);
    private static boolean booleanLower = TestConstants.DEFAULT_BOOL;
    private static Boolean booleanUpper = Boolean.valueOf(TestConstants.DEFAULT_BOOL);
    private static short shortLower = TestConstants.DEFAULT_SHORT;
    private static Short shortUpper = Short.valueOf(TestConstants.DEFAULT_SHORT);
    private static int int1 = TestConstants.DEFAULT_INT;
    private static Integer integer1 = Integer.valueOf(TestConstants.DEFAULT_INT);
    private static long longLower = TestConstants.DEFAULT_LONG;
    private static Long longUpper = Long.valueOf(TestConstants.DEFAULT_LONG);
    private static float floatLower = TestConstants.DEFAULT_FLOAT;
    private static Float floatUpper = Float.valueOf(TestConstants.DEFAULT_FLOAT);
    private static double doubleLower = TestConstants.DEFAULT_DOUBLE;
    private static Double doubleUpper = Double.valueOf(TestConstants.DEFAULT_DOUBLE);
    private static BigDecimal bigDecimal = TestConstants.DEFAULT_BIGDECIMAL;
    private static TestTableEntity testTableEntity = new TestTableEntity();
    private static List list = new LinkedList();
    private static Map map = new HashMap(1);

    public static String getString() {
        return string;
    }

    public static StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public static StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public static byte getByteLower() {

        return byteLower;
    }

    public static Byte getByteUpper() {

        return byteUpper;
    }

    public static char getCharLower() {

        return charLower;
    }

    public static Character getCharUpper() {

        return charUpper;
    }

    public static boolean getBooleanLower() {

        return booleanLower;
    }

    public static Boolean getBooleanUpper() {

        return booleanUpper;
    }

    public static short getShortLower() {

        return shortLower;
    }

    public static Short getShortUpper() {

        return shortUpper;
    }

    public static int getInt() {

        return int1;
    }

    public static Integer getInteger() {

        return integer1;
    }

    public static long getLongLower() {

        return longLower;
    }

    public static Long getLongUpper() {

        return longUpper;
    }

    public static float getFloatLower() {

        return floatLower;
    }

    public static Float getFloatUpper() {

        return floatUpper;
    }

    public static double getDoubleLower() {

        return doubleLower;
    }

    public static Double getDoubleUpper() {

        return doubleUpper;
    }

    public static BigDecimal getBigDecimal() {

        return bigDecimal;
    }

    public static TestTableEntity getTestTableEntity() {

        return testTableEntity;
    }

    public static List getList() {

        return list;
    }

    public static Map getMap() {

        return map;
    }
}
