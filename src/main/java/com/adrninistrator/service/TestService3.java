package com.adrninistrator.service;

import com.adrninistrator.dao.entity.TestTableEntity;

public interface TestService3 {

    int insert(TestTableEntity testTableEntity);

    TestTableEntity select(String id);
}
