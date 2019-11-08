package com.test.service.impl;

import com.test.dao.TestTableMapper;
import com.test.dao.entity.TestTableEntity;
import com.test.service.TestService3;
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
