package com.test.service.impl;

import com.test.service.TestServiceA1;
import com.test.service.TestServiceB1;
import com.test.service.TestServiceC1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceC1Impl implements TestServiceC1 {

    @Autowired
    private TestServiceA1 testServiceA1;

    @Autowired
    private TestServiceB1 testServiceB1;

    @Override
    public String test1(String str) {
        return testServiceB1.test1(str);
    }

    @Override
    public String test2(String str) {
        return testServiceA1.test1(str);
    }
}
