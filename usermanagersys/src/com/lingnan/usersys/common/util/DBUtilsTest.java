package com.lingnan.usersys.common.util;




import java.sql.Connection;

import org.junit.Test;

/**
 * 数据库测试类
 * @author Administrator
 *
 */
public class DBUtilsTest {

	@Test
	public void testGetConnection() {
		Connection conn=DBUtils.getConnection();
		System.out.println(conn);
	}

}
