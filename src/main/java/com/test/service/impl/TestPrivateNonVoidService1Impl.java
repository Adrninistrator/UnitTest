package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestPrivateNonVoidService1;
import com.test.static1.TestStaticPrivateNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.springframework.stereotype.Service;

@Service
public class TestPrivateNonVoidService1Impl implements TestPrivateNonVoidService1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";

    private String test1(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    @Override
    public String testPublic1(String str) {
        return test1(str);
    }

    @Override
    public String testStatic1(String str, TestTableEntity testTableEntity) {

        return TestStaticPrivateNonVoid1.testPublic1(str, testTableEntity);
    }
}
