package com.test.service;

import com.test.non_static.TestNonStaticNoArg1;
import com.test.non_static.TestNonStaticWithArg1;

public interface TestService1 {

    TestNonStaticNoArg1 genNoArg1();

    TestNonStaticWithArg1 genWithArg1(String str1);

    TestNonStaticWithArg1 genWithArg2(String str1, String str2);
}
