package com.rzx.ssm.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.UserMapper;

@Service(value="mainService")
public class MainService {

	@Autowired
	public UserMapper userMapper;
	
	public boolean checkUserExist(User user){
		return userMapper.userExist(user)==null?false:true;
	}
	
	public void insertUser(User user){
		user.setcUuid(UUID.randomUUID().toString());
		userMapper.insert(user);
	}
	
}
