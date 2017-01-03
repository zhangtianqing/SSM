package com.rzx.ssm.mapperTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rzx.ssm.entity.TestTable;
import com.rzx.ssm.mapper.TestTableMapper;

public class TestTableTest extends TestTable {

	@Autowired
	TestTableMapper mapper;
	
	@Test
	public void testISUDDate(){
		TestTable table=new TestTable("name is jack ");
		System.out.println(mapper.insert(table));
	}
}
