package com.adrninistrator.service;

import com.adrninistrator.dao.entity.TestTableEntity;

public interface TestPublicNonVoidService1 {

    String test1(String str);

    String test2(String str);

    String test3(String str);

    String testStatic1(String str, TestTableEntity testTableEntity);

    String getStaticFlag();

    String getStaticFlag2();
}
