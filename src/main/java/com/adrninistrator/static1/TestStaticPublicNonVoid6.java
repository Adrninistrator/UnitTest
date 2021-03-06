package com.adrninistrator.static1;

import com.adrninistrator.common.constants.TestConstants;

public class TestStaticPublicNonVoid6 {

    public static String testChar(char value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testBoolean(boolean value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testByte(byte value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testShort(short value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testInt(int value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testLong(long value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testFloat(float value) {
        return TestConstants.NOT_MOCKED;
    }

    public static String testDouble(double value) {
        return TestConstants.NOT_MOCKED;
    }

    private TestStaticPublicNonVoid6() {
        throw new IllegalStateException("illegal");
    }
}
