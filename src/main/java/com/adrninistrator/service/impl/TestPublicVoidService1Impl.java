package com.adrninistrator.service.impl;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPublicVoidService1;
import com.adrninistrator.static1.TestStaticPublicVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

@Service
public class TestPublicVoidService1Impl implements TestPublicVoidService1 {

    public static final String NAME_TEST1 = "test1";

    @Override
    public void test1(StringBuilder stringBuilder) {
        TestCallTimesUtil.addCallTimes();

        stringBuilder.append(TestConstants.NOT_MOCKED);
    }

    @Override
    public void testStatic1(StringBuilder stringBuilder) {
        TestStaticPublicVoid1.test1(stringBuilder);
    }
}
