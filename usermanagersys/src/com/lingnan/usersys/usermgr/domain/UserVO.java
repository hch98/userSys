package com.lingnan.usersys.usermgr.domain;

/**
 * 用户信息类
 * @author Administrator
 *
 */

public class UserVO {
	  private String userId;  	    //用户编号	  
	  private String username;     	//用户姓名
	  private String passwd;        //用户密码
	  private String  power;        //权限
	  private String sex;           //性别
	  private int age;              //年龄
	  private String tel;           //联系方式
	  private String address;       //地址
	   
	  
	 /**
	  * 取得用户编号  
	  * @return 编号
	  */
	  public String getUserId() {
			return userId;
		}
	    
	  
	  /**
	   * 设定用户编号为指定参数的值
	   * @param userId
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
		 * @param username
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
		 * @param passwd
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
		 * @param power
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
		 * @param sex
		 */
		public void setSex(String sex) {
			this.sex = sex;
		}
		
		/**
		 * 取得用户年龄
		 * @return 年龄
		 */
		public int getAge() {
			return age;
		}
		
		/**
		 * 设定用户年龄为指定参数的值
		 * @param age
		 */
		public void setAge(int age) {
			this.age = age;
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
		 * @param tel
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
		 * @param address
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
		 * @param userId
		 * @param username
		 * @param passwd
		 * @param power
		 * @param sex
		 * @param age
		 * @param tel
		 * @param address
		 */
		public UserVO(String userId, String username, String passwd, String power,
				String sex, int age, String tel, String address) {
			super();
			this.userId = userId;
			this.username = username;
			this.passwd = passwd;
			this.power = power;
			this.sex = sex;
			this.age = age;
			this.tel = tel;
			this.address = address;
		}
	

	
}