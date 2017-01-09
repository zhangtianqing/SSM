package com.rzx.ssm.mapper;

import com.rzx.ssm.entity.TestTable;

public interface TestTableMapper {


    int insertOnlyTest1(String test1);
    
    int insert(TestTable record);

    int insertSelective(TestTable record);
    
    int deleteByPrimaryKey(Integer id);

    TestTable selectByPrimaryKey(Integer id);
    
    TestTable selectByVarcharTest1(String test1);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKey(TestTable record);
    
    int updateByTest1(TestTable table);
}