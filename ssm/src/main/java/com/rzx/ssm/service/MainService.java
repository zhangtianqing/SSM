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
	
}
