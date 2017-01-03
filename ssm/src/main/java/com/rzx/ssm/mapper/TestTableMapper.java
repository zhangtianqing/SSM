package com.rzx.ssm.mapper;

import com.rzx.ssm.entity.TestTable;

public interface TestTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insertOnlyTest1(String test1);
    
    int insert(TestTable record);

    int insertSelective(TestTable record);

    TestTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKey(TestTable record);
}