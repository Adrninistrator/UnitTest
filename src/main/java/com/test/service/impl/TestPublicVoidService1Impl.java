package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.service.TestPublicVoidService1;
import com.test.static1.TestStaticPublicVoid1;
import com.test.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

@Service
public class TestPublicVoidService1Impl implements TestPublicVoidService1 {

    public static final String NAME_TEST1 = "test1";

    @Override
    public void test1(StringBuffer stringBuffer) {

        TestCallTimesUtil.addCallTimes();

        stringBuffer.append(TestConstants.NOT_MOCKED);
    }

    @Override
    public void testStatic1(StringBuffer stringBuffer) {
        TestStaticPublicVoid1.test1(stringBuffer);
    }
}
