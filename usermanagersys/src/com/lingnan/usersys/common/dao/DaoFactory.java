package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.usermgr.dao.UserDaoImpl;


/**
 * dao工厂
 * @author Administrator
 *
 */
public class DaoFactory {

	/**
	 *  获得用户dao对象的工厂方法
	 * @param conn 数据库连接对象
	 * @param type dao常量
	 * @return dao接口
	 */
	public static BaseDao getDao(Connection conn,String type){
		//如果传入的dao类型是用户user,就实例化用户dao实现类
		if ("user".equals(type)) {
			//返回实例化的dao对象
			return new UserDaoImpl(conn);
		}
		//如果没有以上指定的类型匹配的值，就提示错误信息
		else{
			throw new ServiceException("dao工厂方法出错");
		}
	
	}
}
