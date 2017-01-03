package com.rzx.ssm.mapper;

import com.rzx.ssm.entity.testTable;

public interface testTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(testTable record);

    int insertSelective(testTable record);

    testTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(testTable record);

    int updateByPrimaryKey(testTable record);
}