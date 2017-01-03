package com.rzx.ssm.mapper;

import com.rzx.ssm.entity.User;
import com.rzx.ssm.entity.UserKey;

public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);

    User selectByU_Uuid(String u_uuid);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User userExist(User user);
    
    User userExistByUsername(String username);
    
    int deleteUserByUuid(String uUuid);
}