package com.lingnan.usersys.common.util;


import java.util.Date;

import org.junit.Test;

/**
 * 类型转换类测试
 * @author Administrator
 *
 */
public class TypeUtilsTest {

	@Test
	public void testStrToDate() {
		String  s = "2016-08-07";
		Date d=null;
		d=TypeUtils.strToDate(s);
		System.out.println(d);
	}

	@Test
	public void testDateToStr() {

        Date date=new Date();
		String s=TypeUtils.dateToStr(date);
		System.out.println(s);
	}

	@Test
	public void testCheckEmail() {
		String email="123@qq.com";
		boolean flag=TypeUtils.checkEmail(email);
		System.out.println("email"+flag);
	}


	@Test
	public void testCheckPhone() {
		String phone="15768403663";
		boolean flag=TypeUtils.checkPhone(phone);
		System.out.println("phnoe:"+flag);
	}

}
