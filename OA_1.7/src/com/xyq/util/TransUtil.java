package com.xyq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransUtil {
	
	/**
	 * 日期类型转字符串
	 * @param date
	 * @return
	 */
	public static String date2str(Date date){
		if(date != null){
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sft.format(date);
			return dateStr;
		}else{
			return "";
		}
		
	}
	
	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date str2date(String str){
		if(str != null && !"".equals(str)){
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sft.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}else{
			return null;
		}
		
		
	}
	
	/**
	 * 字符串转数字
	 * @param str
	 * @return
	 */
	public static int str2int(String str){
		if(str != null && !"".equals(str)){
			int num = Integer.valueOf(str);
			return num;
		}else{
			return 0;
		}
		
	}
	
	/**
	 * util日期转SQL日期
	 * @param date
	 * @return
	 */
	public static java.sql.Date utildate2SQLDate(Date date){
		if(date != null){
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			return sqlDate;
		}else{
			return null;
		}
		
	}
	
	/**
	 * SQL日期转Util日期
	 * @param date
	 * @return
	 */
	public static Date sqldate2UtilDate(java.sql.Date date){
		if(date != null){
			Date utilDate = new Date(date.getTime());
			return utilDate;
		}else{
			return null;
		}
		
	}
	
}
