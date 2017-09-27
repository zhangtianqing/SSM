package com.rzx.ssm.po;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.controller.MsgProcessor;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.ClasssMapper;
import com.rzx.ssm.mapper.UserMapper;
import com.rzx.ssm.service.MainService;

public class MoreThread implements Runnable{

	@Autowired MainService mainService;
	@Autowired UserMapper userMapper;
	public void run() {
		// TODO Auto-generated method stub
		//执行
		mainService.insertUser(new User("123", 0, new Date()));
	}

}
