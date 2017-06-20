package com.hola.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  获取各种id工具类
 * @author Dougest
 * 2017年6月2日   下午12:31:40
 *
 */
public class IDFactory {
	/**
	 * 允许的类型
	 */
	public static final Map<String,String> IDType = new HashMap<String,String>();
	static{
		IDType.put("yyyy-MM-dd HH-mm-ss", "yyyy-MM-dd HH-mm-ss");
		IDType.put("yyyy-MM-dd", "yyyy-MM-dd");
		IDType.put("yyyy/MM/dd HH/mm/ss", "yyyy/MM/dd HH/mm/ss");
		IDType.put("yyyy/MM/dd", "yyyy/MM/dd");
		IDType.put("yyyyMMddHHmmss", "yyyyMMddHHmmss");
		IDType.put("yyyyMMdd", "yyyyMMdd");
	}
	/**
	 * 日期精确到日加上当天所有毫秒数加上三位随机数
	 */
	public static String getTimestampToMSAndRandom(){
		//当前时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		//获取当前时间精确到秒
		String firstPart = format.format(date);
		String MS = date.getTime()+"";
		//获取毫秒后三位
		String secondPart = MS.substring(MS.length()-3,MS.length());
		//随机获取三个字母
		String thirdPart = getRandomChar(4);
		return firstPart+"-"+secondPart+thirdPart;
	}
	/**
	 * 按指定的格式格式化时间
	 * 如果传入date则格式化此时间如果传入为null则格式化当前时间
	 * @param myDate 
	 * @param type
	 * @return
	 */
	public static String formatDateByType(Date myDate , String type){
		Date date = myDate==null?(new Date()):myDate;
		SimpleDateFormat format = new SimpleDateFormat(type);
		String str = format.format(date);
		return str;
	}
	/**
	 * 获取指定个数的数字加字母包含大小写
	 * @param need
	 * @return
	 */
	public static String getRandomChar(int need){
		char[] allChar ={'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'}; 
		String result ="";
		if(need<=0)return "";
		for(int i=1;i<=need;i++){
			int num = (int)(Math.random()*(allChar.length));
			result +=allChar[num];
		}
		return result;
	}
	/**
	 * 获取指定个数的数字
	 * @param need
	 * @return
	 */
	public static String getRandomNumber(int need){
		char[] allChar ={'1','2','3','4','5','6','7','8','9','0'}; 
		String result ="";
		if(need<=0)return "";
		for(int i=1;i<=need;i++){
			int num = (int)(Math.random()*(allChar.length));
			result +=allChar[num];
		}
		return result;
	}
	public static void main(String[] asd){
		String str = getTimestampToMSAndRandom();
		System.out.println(str);
	}
}
