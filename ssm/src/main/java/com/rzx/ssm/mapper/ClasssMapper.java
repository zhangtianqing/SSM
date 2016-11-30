package com.rzx.ssm.mapper;

import com.rzx.ssm.entity.ClasssKey;

public interface ClasssMapper {
    int deleteByPrimaryKey(ClasssKey key);

    int insert(ClasssKey record);

    int insertSelective(ClasssKey record);
    
    ClasssKey selectClasssByClasssName(String classsName);
}