package com.adrninistrator.static1;

public class TestStaticPublicNonVoid4 {

    private static boolean run;

    static {
        run = true;
    }

    public static boolean isRun() {
        return run;
    }

    private TestStaticPublicNonVoid4() {
        throw new IllegalStateException("illegal");
    }
}
