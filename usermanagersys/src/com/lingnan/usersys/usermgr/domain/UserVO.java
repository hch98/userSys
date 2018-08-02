package com.lingnan.usersys.usermgr.domain;

/**
 * 用户信息类
 * @author Administrator
 *
 */

public class UserVO {
	  
	  /**
	   * 用户编号
	   */
	  private String userId;  	   
	  
	  /**
	   * 用户姓名
	   */
	  private String username;  
	  
	  /**
	   * 用户密码
	   */
	  private String passwd;        
	  
	  /**
	   * 权限
	   */
	  private String power;      
	  
	  /**
	   * 性别
	   */
	  private String sex;           
	  
	  /**
	   * 邮箱
	   */
	  private String email;         
	  
	  /**
	   * 联系方式
	   */
	  private String tel;           
	  
	  /**
	   * 地址
	   */
	  private String address;       
	   
	  
	 /**
	  * 取得用户编号  
	  * @return 编号
	  */
	  public String getUserId() {
			return userId;
		}
	    
	  
	  /**
	   * 设定用户编号为指定参数的值
	   * @param userId  用户编号
	   */
	  
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
				
		/**
		 * 取得用户姓名
		 * @return 姓名
		 */
		public String getUsername() {
			return username;
		}
		
		/**
		 * 设定用户姓名为指定参数的值
		 * @param username 用户名称
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		/**
		 * 取得用户密码
		 * @return 用户密码
		 */
		public String getPasswd() {
			return passwd;
		}
		
				
		/**
		 * 设定用户密码为指定参数的值
		 * @param passwd  密码
		 */
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		
		
		/**
		 * 取得用户权限
		 * @return 权限
		 */
		public String getPower() {
			return power;
		}
		
				
		/**
		 * 设定用户权限为指定参数的值
		 * @param power 权限
		 */
		public void setPower(String power) {
			this.power = power;
		}
		
		
		/**
		 * 取得用户性别 
		 * @return 性别
		 */
		public String getSex() {
			return sex;
		}
		
		/**
		 * 设定用户性别为指定参数的值
		 * @param sex 性别
		 */
		public void setSex(String sex) {
			this.sex = sex;
		}
		
		/**
		 * 取得用户邮箱
		 * @return 邮箱
		 */
		public String getEmail() {
			return email;
		}
		
		/**
		 * 设定用户邮箱为指定参数的值
		 * @param email 邮箱
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
		 * 取得用户联系方式
		 * @return 联系方式
		 */
		public String getTel() {
			return tel;
		}
		
		/**
		 * 设定用户联系方式为指定参数的值
		 * @param tel 联系电话
		 */
		public void setTel(String tel) {
			this.tel = tel;
		}
		
		/**
		 * 取得用户地址
		 * @return 地址
		 */
		public String getAddress() {
			return address;
		}
		
		/**
		 * 设定用户地址为指定参数的值
		 * @param address  地址
		 */
		public void setAddress(String address) {
			this.address = address;
		}	
	
			
		/**
		 * 默认构造方法
		 */
		public UserVO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		/**
		 * 构造方法
		 * @param userId 用户编号
		 * @param username 用户姓名
		 * @param passwd   密码
		 * @param power  权限
		 * @param sex  性别
		 * @param email  邮箱
		 * @param tel  联系电话
		 * @param address 地址
		 */
		public UserVO(String userId, String username, String passwd, String power,
				String sex, String email, String tel, String address) {
			super();
			this.userId = userId;
			this.username = username;
			this.passwd = passwd;
			this.power = power;
			this.sex = sex;
			this.email = email;
			this.tel = tel;
			this.address = address;
		}
	

	
}