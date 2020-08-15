package com.adrninistrator.dao;

import com.adrninistrator.dao.entity.TestTableEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(TestTableEntity record);

    int insertSelective(TestTableEntity record);

    TestTableEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestTableEntity record);

    int updateByPrimaryKey(TestTableEntity record);

    TestTableEntity selectRecord(@Param("id1") String id1, @Param("id2") String id2);

    int insertIgnore(TestTableEntity record);

    int insertIgnoreBatch(List<TestTableEntity> list);

    int insertOrUpdate(TestTableEntity entity);

    int insertOrUpdateBatch(List<TestTableEntity> list);

    int replaceInto(TestTableEntity entity);

    int replaceIntoBatch(List<TestTableEntity> list);
}