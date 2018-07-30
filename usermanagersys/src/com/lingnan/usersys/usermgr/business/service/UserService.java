package com.lingnan.usersys.usermgr.business.service;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 
 * @author Administrator
 *
 */
public interface UserService {
	
	 /**
	 * 用户登录
	 * @param userId 用户编号
	 * @param passwd 用户密码
	 * @return  用户信息
	 */	
	public UserVO login(String userId,String passwd);
	
	
}
