package com.adrninistrator.service.impl;

import com.adrninistrator.non_static.TestNonStaticNoArg1;
import com.adrninistrator.non_static.TestNonStaticWithArg1;
import com.adrninistrator.service.TestService1;
import org.springframework.stereotype.Service;

@Service
public class TestService1Impl implements TestService1 {

    @Override
    public TestNonStaticNoArg1 genNoArg1() {
        return new TestNonStaticNoArg1();
    }

    @Override
    public TestNonStaticWithArg1 genWithArg1(String str1) {
        return new TestNonStaticWithArg1(str1);
    }

    @Override
    public TestNonStaticWithArg1 genWithArg2(String str1, String str2) {
        return new TestNonStaticWithArg1(str1, str2);
    }
}
