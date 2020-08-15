package com.adrninistrator.service.impl;

import com.adrninistrator.service.TestServiceA1;
import com.adrninistrator.service.TestServiceB1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceB1Impl implements TestServiceB1 {

    public static final String NAME_TEST1 = "test1";

    @Autowired
    private TestServiceA1 testServiceA1;

    @Override
    public String test1(String str) {
        return testServiceA1.test1(str);
    }

    @Override
    public void test2(StringBuilder stringBuilder) {
        testServiceA1.test2(stringBuilder);
    }

    @Override
    public String test3(String str) {
        return testServiceA1.test3(str);
    }
}
