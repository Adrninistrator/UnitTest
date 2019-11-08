package com.test.service;

import com.test.dao.entity.TestTableEntity;

public interface TestPrivateNonVoidService1 {

    String testPublic1(String str);

    String testStatic1(String str, TestTableEntity testTableEntity);
}
