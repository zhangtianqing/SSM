package com.rzx.ssm.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rzx.ssm.service.MainService;

@Controller
@RequestMapping(value="/scan")
public class ScanCodeLoginController {

	@Autowired
	MainService mainService;
	
	/**
	 * 扫码端请求资源
	 * @param userid
	 * @param codeid
	 * @return
	 */
	@RequestMapping(value="/login/{userid}/{codeid}")
	public boolean scanLoginAsModelPhone(@PathVariable String userid,@PathVariable String codeid,HttpSession session){
		return mainService.updateLoginState(codeid, codeid);
	}
	
	/**
	 * Browser 
	 * @param codeid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login/{codeid}")
	@ResponseBody
	public boolean scanLogin(@PathVariable String codeid,HttpSession session){
		System.out.println(codeid+"\t请求资源");
		//检测数据库是否有对应的数据，
		switch (mainService.codeLogin(codeid)) {
		case -1:
			System.out.println("database data insert failed");
			return mainService.codeLogin(codeid)==-1?false:true;
		case 0:
		case 1:
			System.out.println("database hadn't data record with code "+codeid);
			return false;
		case 2:
			System.out.println("found data！ allow login");
			return true;
		}
		//默认失败
		return false;
	}
}
