package com.test.service.impl;

import com.test.service.TestServiceB1;
import com.test.service.TestServiceC2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceC2Impl implements TestServiceC2 {

    @Autowired
    private TestServiceB1 testServiceB1;

    @Override
    public String test1(String str) {
        return testServiceB1.test1(str);
    }
}
