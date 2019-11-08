package com.test.service;

import com.test.dao.entity.TestTableEntity;

public interface TestTxService1 {

    void withTx(String id);

    void withOutTx(String id);

    TestTableEntity select(String id);
}
