package com.lingnan.usersys.common.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;

public class UserDaoImplTest {

	@Test
	public void testLogin() {
		Connection conn=DBUtils.getConnection();		
		UserDaoImpl u1=new UserDaoImpl(conn);
		String userId="u01";
		String passwd="aaa";	
		u1.login(userId,passwd);
		
	}

	@Test
	public void testAddUser() {
		Connection conn=DBUtils.getConnection();		
		UserDaoImpl u2=new UserDaoImpl(conn);
	}

}
