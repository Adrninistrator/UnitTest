package com.adrninistrator.service;

import com.adrninistrator.dao.entity.TestTableEntity;

public interface TestTxService1 {

    void withTx(String id);

    void withOutTx(String id);

    TestTableEntity select(String id);
}
