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
	 * 扫描端使用
	 * @param userid
	 * @param codeid
	 * @return
	 */
	@RequestMapping(value="/login/{userid}/{codeid}")
	public boolean scanLoginAsModelPhone(@PathVariable String userid,@PathVariable String codeid,HttpSession session){
		if (mainService.getUserByU_Uid(codeid)) {
			  session.setAttribute("result", "true"); ;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Browser 使用
	 * @param codeid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login/{codeid}")
	@ResponseBody
	public boolean scanLogin(@PathVariable String codeid,HttpSession session){
		System.out.println(codeid+"\t 获取登陆信息请求");
//		if (session.getAttribute("result")==null||!session.getAttribute("result").toString().equals(codeid)) {
//			return false;
//		}
		return true;
	}
}
