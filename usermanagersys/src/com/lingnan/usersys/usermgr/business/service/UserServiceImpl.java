package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.dao.UserDAO;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserServiceImpl implements UserService {

	/**
	 * 用户Service类实例，在类的内部创建唯一的实例
	 */
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 构造方法私有化
	 */
	private UserServiceImpl() {
		
	}
	
	/**
	 * 取得用户Service的实例
	 * 提供对外访问的方法
	 * @return 实例对象
	 */
	public static UserService getInstance() {
		return userService;
	}
	
	
	/**
	 * 用户登录
	 * @param userId 用户编号
	 * @param passwd 用户密码
	 * @return  用户信息
	 */		
	public UserVO login(String userId, String passwd) {
		Connection conn = null;
		UserVO user = null;
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDAO userMgrDao=(UserDAO) DaoFactory.getDao(conn,EnumType.USER_DAO);
			//调用dao中的login方法，进行登录操作，结果赋值给登录的结果变量
			user=userMgrDao.login(userId, passwd);
		}catch (DaoException e) {
			//将自定义异常抛出
			throw e;
		}catch (Exception e) {
			//将异常封装为自定义异常并且抛出
			throw new ServiceException("用户登录错误",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return user;
	}

	
	
	
	
	
	
	
}
