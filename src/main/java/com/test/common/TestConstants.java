package com.test.common;

import java.math.BigDecimal;

public class TestConstants {

    public static final String NOT_MOCKED = "NOT_MOCKED";

    public static final String MOCKED = "MOCKED";

    public static final String FLAG1 = "flag1";
    public static final String FLAG2 = "flag2";
    public static final String FLAG3 = "flag3";

    public static final byte DEFAULT_BYTE = 123;
    public static final char DEFAULT_CHAR = 123;
    public static final boolean DEFAULT_BOOL = true;
    public static final short DEFAULT_SHORT = 123;
    public static final int DEFAULT_INT = 123;
    public static final long DEFAULT_LONG = 123L;
    public static final float DEFAULT_FLOAT = 123.0F;
    public static final double DEFAULT_DOUBLE = 123.0D;
    public static final BigDecimal DEFAULT_BIGDECIMAL = BigDecimal.valueOf(123.0D);

    public static final String DOLOR = "$";

    public static final String MINUS = "-";

    //通过调用堆栈获取的构造函数方法名
    public static final String NAME_CONSTRUCTOR = "<init>";

    //旧版Mockito的jar包名字
    public static final String MOCKITO_JAR_NAME_OLD = "mockito-core-1.";

    //最新版PowerMock的jar包名字（2.0.2，Apr, 2019）
    public static final String POWERMOCK_JAR_NAME_NEWEST = "powermock-core-2.0.2.jar";

    private TestConstants() {
        throw new IllegalStateException("illegal");
    }
}
