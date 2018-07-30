package com.lingnan.usersys.common.dao;


import com.lingnan.usersys.usermgr.domain.UserVO;


public interface UserDAO extends BaseDao {
	
	
	/**
	 * 用户登录
	 * @param userId 用户编号
	 * @param passwd 用户密码
	 * @return  用户信息
	 */
	public UserVO login(String userId,String passwd);
	
	
	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user);
	
	
	/**
	 * 删除用户
	 * @param userId 用户编号
	 * @return 成功返回true，失败返回false
	 */
	public boolean deleteUserById(String userId);
	
	
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean updateUser(UserVO user);
	
//		
//	public UserVO findByUid(String uid);
//
//	public List<UserVO> findAll();
}



