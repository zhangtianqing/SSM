package com.rzx.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzx.ssm.controller.msg.ResponseMessage;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.UserMapper;

@Service(value="mainService")
public class MainService {

	@Autowired UserMapper userMapper;
	
	public boolean checkUserExist(User user){
		return userMapper.userExist(user)==null?false:true;
	}
	
	public boolean checkUserExistByUsername(String username){
		return userMapper.userExistByUsername(username)==null?false:true;
	}
	
	public boolean getUserByU_Uid(String u_uuid){
		return userMapper.selectByU_Uuid(u_uuid)==null?false:true;
	}
//	public boolean deleteUserByUuid(String uuid){
//		return 
//	}
}
