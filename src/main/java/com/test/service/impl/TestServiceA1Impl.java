package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.service.TestServiceA1;
import org.springframework.stereotype.Service;

@Service
public class TestServiceA1Impl implements TestServiceA1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";
    public static final String NAME_TEST3 = "test3";
    public static final String NAME_TEST4 = "test4";
    public static final String NAME_TEST_PRIVATE3 = "testPrivate3";
    public static final String NAME_TEST_PRIVATE4 = "testPrivate4";

    @Override
    public String test1(String str) {
        return TestConstants.NOT_MOCKED;
    }

    @Override
    public void test2(StringBuffer stringBuffer) {
        stringBuffer.append(TestConstants.NOT_MOCKED);
    }

    @Override
    public String test3(String str) {
        return testPrivate3(str);
    }

    @Override
    public void test4(StringBuffer stringBuffer) {
        testPrivate4(stringBuffer);
    }

    private String testPrivate3(String str) {
        return TestConstants.NOT_MOCKED;
    }

    private void testPrivate4(StringBuffer stringBuffer) {
        stringBuffer.append(TestConstants.NOT_MOCKED);
    }
}
