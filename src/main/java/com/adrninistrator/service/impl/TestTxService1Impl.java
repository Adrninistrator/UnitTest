package com.adrninistrator.service.impl;

import com.adrninistrator.common.constants.TestConstants;
import com.adrninistrator.dao.TestTableMapper;
import com.adrninistrator.dao.entity.TestTableEntity;
import com.adrninistrator.service.TestTxService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TestTxService1Impl implements TestTxService1 {

    @Autowired
    private TestTableMapper testTableMapper;

    @Transactional
    @Override
    public void withTx(String id) {
        test(id);
    }

    @Override
    public void withOutTx(String id) {
        test(id);
    }

    @Override
    public TestTableEntity select(String id) {
        return testTableMapper.selectByPrimaryKey(id);
    }

    private void test(String id) {
        TestTableEntity testTableEntity = new TestTableEntity();

        Date date = new Date();

        testTableEntity.setId(id);
        testTableEntity.setFlag(TestConstants.FLAG1);
        testTableEntity.setCreateTime(date);
        testTableEntity.setUpdateTime(date);

        testTableMapper.insert(testTableEntity);

        testTableEntity.setFlag(TestConstants.FLAG2);

        testTableMapper.updateByPrimaryKeySelective(testTableEntity);
    }
}
