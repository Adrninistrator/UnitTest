package com.adrninistrator.service.impl;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.service.TestPrivateVoidService1;
import com.adrninistrator.static1.TestStaticPrivateVoid1;
import com.adrninistrator.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

@Service
public class TestPrivateVoidService1Impl implements TestPrivateVoidService1 {

    public static final String NAME_TEST1 = "test1";

    private void test1(StringBuilder stringBuilder) {
        TestCallTimesUtil.addCallTimes();

        if (stringBuilder == null) {
            return;
        }

        stringBuilder.append(TestConstants.NOT_MOCKED);
    }

    @Override
    public void testStatic1(StringBuilder stringBuilder) {
        TestStaticPrivateVoid1.testPublic1(stringBuilder);
    }
}
