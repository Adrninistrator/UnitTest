package com.test.service.impl;

import com.test.common.TestConstants;
import com.test.service.TestPublicNonVoidService1;
import com.test.service.TestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService2Impl implements TestService2 {

    //测试时会使用
    @Autowired
    private TestPublicNonVoidService1 testPublicNonVoidService1;

    @Override
    public String test1(String str) {
        return TestConstants.NOT_MOCKED;
    }
}
