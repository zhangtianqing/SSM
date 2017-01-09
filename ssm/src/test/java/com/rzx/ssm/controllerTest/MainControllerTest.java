package com.rzx.ssm.controllerTest;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rzx.ssm.controller.MainController;
import com.rzx.ssm.controller.msg.RequestMessage;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapperTest.BasicTest;
import com.rzx.ssm.service.MainService;
import com.rzx.ssm.util.redis.MethodCacheInterceptor;


public class MainControllerTest extends BasicTest {

	private Logger logger = LoggerFactory.getLogger(MainControllerTest.class);  
	@Autowired
	MainService mainService;
	
	
	/**
	 * 
	 * @author LoveIsDrug-snow 
	 * @throws Exception 
	 * @since JDK 1.8
	 */
	@Test
	public void testController() throws Exception{
		User user=new User();
//		user.setUsername("adminstrator");
		user.setUsername("adminstrators");
		user.setPassword("soft");
		ObjectMapper mapper=new ObjectMapper();
		String data=mapper.writeValueAsString(user);
		RequestMessage message=new RequestMessage("123", "check user", "mainService_checkUserExist",data);
		MainController mains=new MainController();
		mains.mainService=mainService;
		System.out.println(mains.Connections(message).toString());
	}
	
	@Test  
	public void getSettUnitBySettUnitIdTest() {  
	    String u_uuid = "24838094943420424";  
	    User configSettUnit=mainService.getUserByU_Uid(u_uuid);
	    User user=mainService.getUserByU_Uid(u_uuid);
	} 
}
