package com.bjsxt.util;

import java.util.Calendar;
/**
 * 处理时间的工具类
 * @company sxt
 * @author fangyl
 * @Date 2018年10月24日
 *
 */
public class DateUtil {
	
	/**
	 * 返回当前月第一天
	 * @return
	 */
	public static String getNowMonthBeginTime(){
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		String str = year+"-"+(month+1)+"-01 00:00:00";
		if(month+1<10){
			str = year+"-0"+(month+1)+"-01 00:00:00";
		}		
		return str;
	}
	
	/**
	 * 返回当前年上半年第一天
	 * @return
	 */
	public static String getNowYearBeginTime(){
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		String str = year+"-01-01 00:00:00";
		return str;
	}
	
	/**
	 * 返回当前年上半年最后第一天
	 * @return
	 */
	public static String getNowYearEndTime(){
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		String str = year+"-06-30 23:59:59";
		return str;
	}
	
		
	/**
	 * 返回当前年下半年的第一天
	 * @return
	 */
	public static String getNowNextYearbeginTime(){
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		String str = year+"-07-01 00:00:00";
		return str;
	}
	
	
	/**
	 * 返回去年第一天
	 * @return
	 */
	public static String getLastYearBeginTime(){
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		String str = (year-1)+"-01-01 00:00:00";
		return str;
	}
	
	/**
	 * 返回去年最后一天
	 * @return
	 */
	public static String getLastYearEndTime(){
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		String str = (year-1)+"-12-31 23:59:59";
		return str;
	}
	
	
	public static void main(String[] args) {
		//去年第一天
		System.out.println(getLastYearBeginTime());
		//去年最后一天
		System.out.println(getLastYearEndTime());
		/**
		 * 当前月第一个天
		 */
		System.out.println(getNowMonthBeginTime());
		//上半年第一天
		System.out.println(getNowYearBeginTime());
		//上半年最后一天
		System.out.println(getNowYearEndTime());
		/**
		 * 下半年第一天
		 */
		System.out.println(getNowNextYearbeginTime());
		
	}
}
