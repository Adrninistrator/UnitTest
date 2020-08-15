package com.adrninistrator.dao;

import com.adrninistrator.dao.entity.TestTable2;
import com.adrninistrator.dao.entity.TestTable2WithBLOBs;

public interface TestTable2Mapper {
    int deleteByPrimaryKey(String id);

    int insert(TestTable2WithBLOBs record);

    int insertSelective(TestTable2WithBLOBs record);

    TestTable2WithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestTable2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TestTable2WithBLOBs record);

    int updateByPrimaryKey(TestTable2 record);
}