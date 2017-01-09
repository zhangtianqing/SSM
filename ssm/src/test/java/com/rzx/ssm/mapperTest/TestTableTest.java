package com.rzx.ssm.mapperTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.TestTable;
import com.rzx.ssm.mapper.TestTableMapper;

public class TestTableTest extends BasicTest {

	@Autowired
	TestTableMapper mapper;
	
	@Test
	public void testISUDDate(){
		String test1="test1231";
		int i=mapper.insertOnlyTest1(test1);
		System.out.println(i);
	}
}
