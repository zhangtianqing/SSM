package com.rzx.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rzx.ssm.entity.TestTable;
import com.rzx.ssm.entity.User;
import com.rzx.ssm.mapper.TestTableMapper;
import com.rzx.ssm.mapper.UserMapper;

@Service(value="mainService")
public class MainService {

	@Autowired 
	UserMapper userMapper;
	
	@Autowired
	TestTableMapper tableMapper;
	
	public boolean checkUserExist(User user){
		return userMapper.userExist(user)==null?false:true;
	}
	
	public boolean checkUserExistByUsername(String username){
		return userMapper.userExistByUsername(username)==null?false:true;
	}
	
	public User getUserByU_Uid(String u_uuid){
		return userMapper.selectByU_Uuid(u_uuid);
	}

	
	/**
	 * 
	 * updateLoginState:鎵爜纭鐧婚檰. <br/> 
	 * TODO閫傜敤鏉′欢 :<br/> 
	 * TODO鎵ц娴佺▼:<br/> 
	 * TODO浣跨敤鏂规硶 :<br/> 
	 * TODO娉ㄦ剰浜嬮」:<br/> 
	 * 
	 * @author LoveIsDrug-snow 
	 * @param code
	 * @param test1
	 * @return 
	 * @since JDK 1.8
	 */
	public boolean updateLoginState(String code,String test1){
		TestTable table=new TestTable();
		table.setTest1(test1);
		table.setTest2(code);
		return tableMapper.updateByTest1(table)==1?true:false;
	}
	
	/**
	 * 
	 * codeLogin:妫�娴嬫暟鎹簱鍐呭. <br/> 
	 * TODO閫傜敤鏉′欢 :<br/> 
	 * TODO鎵ц娴佺▼:<br/> 
	 * TODO浣跨敤鏂规硶 :<br/> 
	 * TODO娉ㄦ剰浜嬮」:<br/> 
	 * 
	 * @author LoveIsDrug-snow 
	 * @param code
	 * @return 濡傛灉涓虹┖ 杩斿洖0骞舵彃鍏ユ暟鎹� 鎻掑叆鏁版嵁澶辫触杩斿洖-1<br>
	 * 		          濡傛灉涓嶄负绌轰絾鏄病鏈夊搴旀暟鎹� 鍒欒繑鍥�1<br>
	 * 		         濡傛灉鏈夋暟鎹垯杩斿洖 2
	 * @since JDK 1.8
	 */
	public int codeLogin(String code){
		return tableMapper.selectByVarcharTest1(code)==null?
				(tableMapper.insertOnlyTest1(code)==1
					?
					0:-1)
				:
				(tableMapper.selectByVarcharTest1(code).getTest2().length()==0
					?
					1:2);
	}
}
