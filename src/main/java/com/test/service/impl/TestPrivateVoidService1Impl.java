package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.service.TestPrivateVoidService1;
import com.test.static1.TestStaticPrivateVoid1;
import com.test.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

@Service
public class TestPrivateVoidService1Impl implements TestPrivateVoidService1 {

    public static final String NAME_TEST1 = "test1";

    private void test1(StringBuffer stringBuffer) {

        TestCallTimesUtil.addCallTimes();

        if (stringBuffer == null) {
            return;
        }

        stringBuffer.append(TestConstants.NOT_MOCKED);
    }

    @Override
    public void testStatic1(StringBuffer stringBuffer) {

        TestStaticPrivateVoid1.testPublic1(stringBuffer);
    }
}
