package com.dt59.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 把字符串类型转换成日期格式
 * */
public class CastDateUtil {
	/**
	 * @param  str:字符串格式
	 * @return Date格式
	 * */
	public static Date getDateFormat(String str){
		Date date=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			date=sdf.parse(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}
}
