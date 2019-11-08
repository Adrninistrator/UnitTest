package com.test.dao;

import com.test.dao.entity.TestTableEntity;
import org.apache.ibatis.annotations.Param;

public interface TestTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(TestTableEntity record);

    int insertSelective(TestTableEntity record);

    TestTableEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestTableEntity record);

    int updateByPrimaryKey(TestTableEntity record);

    TestTableEntity selectRecord(@Param("id1") String id1, @Param("id2") String id2);
}