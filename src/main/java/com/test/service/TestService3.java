package com.test.service;

import com.test.dao.entity.TestTableEntity;

public interface TestService3 {

    int insert(TestTableEntity testTableEntity);

    TestTableEntity select(String id);
}
