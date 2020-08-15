package com.adrninistrator.static1;

import com.adrninistrator.common.constants.TestConstants;

public class TestStaticPublicNonVoid3 {

    public static <T> String test1(T obj) {
        if (obj == null) {
            return "";
        }

        return obj.getClass().getSimpleName();
    }

    public static <T extends Exception> String test2(T obj) {
        if (obj == null) {
            return "";
        }

        return obj.getClass().getSimpleName();
    }

    public static String test3(String str, String... args) {
        return TestConstants.NOT_MOCKED;
    }

    private TestStaticPublicNonVoid3() {
        throw new IllegalStateException("illegal");
    }
}
