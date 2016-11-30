package com.rzx.ssm.mapperTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.ClasssKey;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.ClasssMapper;
import com.rzx.ssm.mapper.UserMapper;

public class UserMapperTest extends BasicTest {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ClasssMapper classsMapper;
	
	@Test
	public void testInsertUser(){
		ClasssKey classsKey=classsMapper.selectClasssByClasssName("计应143");
		User user=new User();
		user.setUsername("adminstrator");
		user.setPassword("soft");
		user.setcUuid(classsKey.getcUuid());
		System.out.println(userMapper.insert(user));
	}
}
