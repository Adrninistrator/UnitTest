package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestPublicNonVoidService1;
import com.test.static1.TestStaticPublicNonVoid1;
import com.test.util.TestCallTimesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPublicNonVoidService1Impl implements TestPublicNonVoidService1 {

    public static final String NAME_TEST1 = "test1";
    public static final String NAME_TEST2 = "test2";
    public static final String NAME_TEST3 = "test3";

    @Autowired
    private TestTableMapper testTableMapper;

    @Override
    public String test1(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    @Override
    public String test2(String str) {

        TestCallTimesUtil.addCallTimes();

        testTableMapper.selectByPrimaryKey(str);

        return TestConstants.NOT_MOCKED;
    }

    @Override
    public String test3(String str) {

        TestCallTimesUtil.addCallTimes();

        return TestConstants.NOT_MOCKED;
    }

    @Override
    public String testStatic1(String str, TestTableEntity testTableEntity) {
        return TestStaticPublicNonVoid1.test1(str, testTableEntity);
    }

    @Override
    public String getStaticFlag() {
        return TestStaticPublicNonVoid1.getFlag();
    }

    @Override
    public String getStaticFlag2() {
        return TestStaticPublicNonVoid1.getFlag2();
    }
}
