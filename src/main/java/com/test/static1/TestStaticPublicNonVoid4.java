package com.test.static1;

public class TestStaticPublicNonVoid4 {

    public static boolean run;

    static {
        run = true;
    }

    public static boolean isRun() {
        return run;
    }
}
