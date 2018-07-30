package com.lingnan.usersys.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用户dao接口的实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDAO {

	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	
	/**
	 * 构造方法
	 * 
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn){
		this.conn=conn;
	}
	
	
	
	
	/**
	 * 用户登录
	 * @param userId 用户编号
	 * @param passwd 用户密码
	 * @return 用户信息
	 */
	public UserVO login(String userId,String passwd){
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs= null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstmt =null;
		//声明用户对象变量，用于保存从结果集取出的数据
		UserVO  user=null;
		try {
			//调用连接对象prepareStatement的方法,得到预编译对象，赋值给预编译对象变量
			pstmt =conn.prepareStatement("select * from u_user where userId=? and passwd=?");
			//调用预编译对象的setXxx()方法，给？号赋值
			pstmt.setString(1, userId);
			pstmt.setString(2, passwd);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs=pstmt.executeQuery();
			//查询结果集不为空，将取出结果集中的各个字段，封装在用户对象各个属性中
			if(rs.next()){
				//创建一个新的用户对象，赋值给用户对象变量
				user=new UserVO();		
				/*
				 * 调用结果集对象中的getXxx()方法，取出各个阶段的值
				 * 然后调用用户对象的setXxx()方法，给属性赋值
				 * 最后新创建的用户对象包含了查询结果中所有字段的值
				 */
				user.setUserId(rs.getString("userId"));
				user.setUsername(rs.getString("username"));
				user.setPasswd(rs.getString("passwd"));
				user.setPower(rs.getString("power"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setTel(rs.getString("tel"));
				user.setAddress(rs.getString("address"));
				
			}
		//如果出现异常，输出异常信息
		}catch (SQLException e) {
			System.out.println("登录时出现错误~~~~~~~~~~");
			//将异常封装为自定义异常
			throw new DaoException("登录时出现错误",e);
		}finally{
			DBUtils.closeStatement(rs, pstmt);
		}
		return user;
	}

	
	
	/**
	 * 注册用户/添加用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user) {
		boolean flag = false;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstmt = null;
		//取出用户对象查询结果中所有字段的值
		String userId =user.getUserId();
		String username=user.getUsername();
		String passwd = user.getPasswd();
		String tel=user.getTel();
		String sex=user.getSex();
		int age=user.getAge();
		String power =user.getPower();
		String address =user.getAddress();
		try {
			//调用连接对象prepareStatement的方法,得到预编译对象，赋值给预编译对象变量
			pstmt =conn.prepareStatement("insert into u_user values(?,?,?,?,?,?,?,?)");
			//调用预编译对象的setXxx()方法，给？号赋值
			pstmt.setString(1, userId);
			pstmt.setString(2, username);
			pstmt.setString(3, passwd);
			pstmt.setString(4, power);
			pstmt.setString(5, sex);
			pstmt.setInt(6, age);
			pstmt.setString(7, tel);
			pstmt.setString(8, address);
			//调用预编译对象的executeUpdate方法，执行更新操作，返回更新结果，赋值给结果集对象变量
			int result =pstmt.executeUpdate();
			//执行成功
			if(result>0)
			flag=true;
			
		}//如果出现异常，输出异常信息 
		catch (Exception e) {
			System.out.println("注册/添加用户出错~~~");
			//将异常封装为自定义异常
			throw new DaoException("注册/添加用户时出现错误",e);
		}finally{
			DBUtils.closeStatement(rs, pstmt);
		}
		return flag;
	}


	
	 /**
	 * 删除用户
	 * @param userId 用户编号
	 * @return 成功返回true，失败返回false
	 */
	public boolean deleteUserById(String userId) {
		boolean flag = false;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstmt = null;
		try {
			//调用连接对象prepareStatement的方法,得到预编译对象，赋值给预编译对象变量
			pstmt=conn.prepareStatement("select * from u_user where userId=?");
			//调用预编译的setXxx()方法，给？号赋值
			pstmt.setString(1, userId);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs=pstmt.executeQuery();
			flag=true;
		}//如果出现异常，输出异常信息	
		catch (Exception e) {
			System.out.println("删除用户出错~~~");
			//将异常封装为自定义异常
			throw new DaoException("删除用户时出现错误",e);
		}
		return flag;
	}


	 /**
	 * 更新用户
	 * @param user 用户信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean updateUser(UserVO user) {
		boolean flag = false;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstmt = null;
		//取出用户对象查询结果中所有字段的值
		String userId =user.getUserId();
		String username=user.getUsername();
		String passwd = user.getPasswd();
		String tel=user.getTel();
		String sex=user.getSex();
		int age=user.getAge();
		String power =user.getPower();
		String address =user.getAddress();
		try {
			//调用连接对象prepareStatement的方法,得到预编译对象，赋值给预编译对象变量
			pstmt =conn.prepareStatement("update u_user set username=?,passwd=?,power=?,sex=?,age=?,tel=?,address=?where userId=?");
			//调用预编译对象的setXxx()方法，给？号赋值
			pstmt.setString(1, username);
			pstmt.setString(2, passwd);
			pstmt.setString(3, power);
			pstmt.setString(4, sex);
			pstmt.setInt(5, age);
			pstmt.setString(6, tel);
			pstmt.setString(7, address);
			pstmt.setString(8, userId);
			//调用预编译对象的executeUpdate方法，执行更新操作，返回更新结果，赋值给结果集对象变量
			int result =pstmt.executeUpdate();
			//执行成功
			if(result>0)
			flag=true;
		}//如果出现异常，输出异常信息	
		catch (Exception e) {
			System.out.println("更新用户出错~~~");
			//将异常封装为自定义异常
			throw new DaoException("更新用户时出现错误",e);
		}
		return flag;
	}


//	public boolean insertuser(UserVO uto) {
//		boolean flag = false;
//		String userId =uto.getUserId();
//		String username=uto.getUsername();
//		String password = uto.getPasswd();
//		String tel=uto.getTel();
//		String sex=uto.getSex();
//		int age=uto.getAge();
//		String power =uto.getPower();
//		String address =uto.getAddress();
//		
//		String sql="insert into user values"
//				+ "('"+userId+"','"+username+"','"+password+"','"+power+"','"+sex+"'"
//						+ ",'"+age+"','"+tel+"','"+address+"')";
//		try
//		{	
//			conn=DBUtils.getConnection();
//			prep=conn.prepareStatement(sql);
//			int result =prep.executeUpdate();
//			if(result>0)
//			flag=true;
//		}
//		catch(SQLException e)
//		{
//			System.out.println("ִ��SQL���ʱ���ִ���");
//			e.printStackTrace();
//		}
//		
//      return flag;
//	}	
	
	
	/**
	 *  
	 * @author Administrator
	 * */
//	public UserVO findByUid(String userId){
//		UserVO sto=null;
//		try {
//  			conn=DBUtils.getConnection();
//  			String sql="select * from student where id=?";
//  			prep=conn.prepareStatement(sql);
//  			prep.setString(1, userId);
//  			ResultSet rs =prep.executeQuery();
//    		if(rs.next())
//    		{
//    			UserVO u = new UserVO();
//    			u.setUserId(rs.getString("userId"));
//    			u.setUsername(rs.getString("username"));
//    			u.setTel(rs.getString("tel"));
//    			u.setSex(rs.getString("sex"));
//    			u.setAge(rs.getInt("age"));
//    			u.setAddress(rs.getString("address"));
//    			u.setPower(rs.getString("power"));
//    		}
//    	}
//    	catch(SQLException e)
//    	{
//    		System.out.println("ִ��SQL���ʱ���ִ���");
//    		e.printStackTrace();
//    	}
//    	return sto;
//	}

	/**
	 *   ɾ���û�
	 * @author Administrator
	 * */
//		public  boolean deleteUserById(String userId){
//			boolean flag = false;
//			try
//			{
//				conn=DBUtils.getConnection();
//				prep=conn.prepareStatement("delete from user where userId =?");
//	            prep.setString(1, userId);
//	            int  count = prep.executeUpdate();
//	            if(count >0)
//	            {
//	            	flag=true;
//	            }
//			}	
//			catch(SQLException e)
//			{
//				System.out.println("ִ��SQL���ʱ���ִ���");
//				e.printStackTrace();
//			}
//			return flag;
//		}
//		
//		/**
//		 *   �����û�
//		 * @author Administrator
//		 * */	
//	
//		public boolean updateUser(UserVO u) {
//			boolean flag = false;		
//			String userId=u.getUserId();
//			String username=u.getUsername();
//			String  passwd=u.getPasswd();
//			String tel=u.getTel();
//			String sex=u.getSex();
//			int age=u.getAge();
//			String address=u.getAddress();
//			String power=u.getPower();
//			try {
//	          String sql1="update user set username='"+username+"',passwd='"+passwd+"',power='"+power+"',sex='"+sex+"',"
//	          		+ "age='"+age+"',tel='"+tel+"',address='"+address+"'where userId='"+userId+"'";
//	          prep=conn.prepareStatement(sql1);
//	          int result =prep.executeUpdate();
//	           	flag=true;
//			} catch (SQLException e) {
//				System.out.println("ִ��SQL���ʱ���ִ���");
//				e.printStackTrace();
//			}
//			return flag;
//		}

}
