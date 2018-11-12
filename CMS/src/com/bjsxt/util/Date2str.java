package com.bjsxt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理
 * @company sxt
 * @author fangyl
 * @Date 2018年10月18日
 *
 */
public class Date2str {
	public  static Date str2date(String  str){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	public  static String  date2str(Date  date){
		 SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
		 String format = sdf.format(date);
	    	return format;
	}
	public static void main(String[] args) {
		Date str2date = str2date("1971-01-01");
		System.out.println(str2date);
	}
}
