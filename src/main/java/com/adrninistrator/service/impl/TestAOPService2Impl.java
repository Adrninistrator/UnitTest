package com.adrninistrator.service.impl;

import com.adrninistrator.service.TestAOPService1;
import com.adrninistrator.service.TestAOPService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAOPService2Impl implements TestAOPService2 {

    @Autowired
    private TestAOPService1 testAOPService1;

    @Override
    public String test1(String str) {
        return testAOPService1.testAround(str);
    }

    @Override
    public String test2(String str) {
        return testAOPService1.test2(str);
    }
}
