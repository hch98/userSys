package com.lingnan.usersys.common.util;

import java.sql.*;

import com.lingnan.usersys.common.exception.DaoException;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DBUtils {

	
   /**
    * 数据库的连接方法
    * @return
    */
	
	public static Connection getConnection(){
		Connection conn=null;
		try{
			//加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="scott";
			String password="scott";
			//获取数据库连接对象
			conn=DriverManager.getConnection(url,user,password); 		
		}catch(SQLException e)
		{
			//将异常封装为自定义异常
			throw new DaoException("不能连接数据库....",e);
			//e.printStackTrace();
		}catch(ClassNotFoundException e){
			
			//将异常封装为自定义异常
			throw new DaoException("不能连接数据库....驱动程序加载错误",e);
			//e.printStackTrace();			
		}
		//返回得到的连接对象
		return conn; 	}
	
	
	
	/**
	 * 开启事务
	 * @param conn
	 */
	
	public static void beginTransaction(Connection conn){
		try{
			//将事务的自动提交模式设为假
			conn.setAutoCommit(false);
		}catch(SQLException e){
			//将异常封装为自定义异常
			throw new DaoException("事务开启失败",e);
		}
	}

	
	
	/**
	 * 提交事务
	 * @param conn
	 */
	
	public static void commit(Connection conn){
		try {
			//提交事务
			conn.commit();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		}catch(SQLException e) {
			//将异常封装为自定义异常
			throw new DaoException("事务提交失败",e);
		}
	}
	
	
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	
	public static void rollback(Connection conn){
		try {
			//回滚事务
			conn.rollback();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		}catch(SQLException e) {
			//将异常封装为自定义异常
			throw new DaoException("事务回滚失败",e);
		}
	}
	
	
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	
	public static void closeConnection(Connection conn){
		try {
			//如果数据对象不为空，关闭对象
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e) {
			//将异常封装为自定义异常
			throw new DaoException("关闭连接失败",e);
		}
	}
	
	
	
	/**
	 * 关闭对象
	 * @param rs
	 * @param stmt
	 */
	
	public static void closeStatement(ResultSet rs,Statement stmt){
		try {
			//查询对象的结果集不为空，关闭该对象
			if(rs != null){
				rs.close();
			}
			//声明对象不为空，关闭该对象
			if(stmt != null){
				stmt.close();
			}
		 }catch(SQLException e) {
			//将异常封装为自定义异常
			throw new DaoException("关闭对象失败",e);
		}
	 }
	
}
