package com.lingnan.usersys.common.util;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.exception.EmailException;
import com.lingnan.usersys.common.exception.PhoneException;

/**
 * 类型转换工具类
 * @author Administrator
 *
 */
public class TypeUtils {

	/**
	 * 字符串转换为日期
	 * @param str 指定字符串
	 * @return 转换后的日期
	 */
	public static Date strToDate(String str){
		Date date=null;	
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用parse方法，将字符串解析成指定格式的日期
			date=sdf.parse(str);
		} catch (ParseException e) {
			//将异常封装为自定义异常
			throw new DateException("字符转换日期出错",e);
		}
		return date;
	}
	
	
	/**
	 * 日期转换为字符串
	 * @param date 指定日期
	 * @return 转化后的字符串
	 */
	public static String dateToStr(Date date){
		String str=null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//调用format方法，将日期格式转换为字符串
			str=sdf.format(date);
		} catch (Exception e) {
			//将异常封装为自定义异常
			throw new DateException("日期转换字符串出错",e);
		}
		return str;
	}
	
	/**
	 * 判断邮箱
	 * @param email
	 * @return
	 */
	
	public static boolean checkEmail(String email){
		try {
			String mail=email.replaceAll("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", ""); 
			if (mail.length() ==0) {
				return true;
			}else {
				System.out.println("邮箱格式错误");
				return false;
			}
		} catch (Exception e) {
			//将异常封装为自定义异常
			throw new EmailException("邮箱格式错误",e);
		}
	}
	
	
	/**
	 * 验证手机号码
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone){
		try {
			//验证手机号
			String tel=phone.replaceAll("^(\\+86|86)?1((3[0-9])|(4[5|7])|(5([0-3]|[5-9]))|(8[0,5-9]))\\d{8}$","");
			//验证带区号的固定电话
			String tel1=phone.replaceAll("^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$", "");
			// 验证没有区号的固定电话
			String tel2=phone.replaceAll("^[1-9]{1}[0-9]{5,8}$","");
			
			if (tel.length() ==0 || tel1.length()==0 ||tel2.length()==0 ) {
				return true;
			}else {
				System.out.println("联系方式的格式错误");
				return false;
			}
		} catch (Exception e) {
			//将异常封装为自定义异常
			throw new PhoneException("号码格式错误",e);
		}
	}
}
