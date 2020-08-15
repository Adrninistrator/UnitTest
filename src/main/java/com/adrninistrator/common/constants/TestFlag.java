package com.adrninistrator.common.constants;

public class TestFlag {

    private static Boolean allLazy;

    public static Boolean isAllLazy() {
        return allLazy;
    }

    public static void setAllLazy(Boolean allLazy) {
        TestFlag.allLazy = allLazy;
    }

    private TestFlag() {
        throw new IllegalStateException("illegal");
    }
}
