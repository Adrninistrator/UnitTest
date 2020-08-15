package com.adrninistrator.service.impl;

import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService3Impl implements TestService3 {

    @Autowired
    private TestTableMapper testTableMapper;

    @Override
    public int insert(TestTableEntity testTableEntity) {
        return testTableMapper.insert(testTableEntity);
    }

    @Override
    public TestTableEntity select(String id) {
        return testTableMapper.selectByPrimaryKey(id);
    }
}
