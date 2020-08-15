package com.adrninistrator.service.impl;

import com.adrninistrator.service.TestServiceB1;
import com.adrninistrator.service.TestServiceC2;
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
