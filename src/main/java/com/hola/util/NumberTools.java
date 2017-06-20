package com.hola.util;
/**
 * 数字工具类
 * @author Dougest
 * 2017年5月25日   下午5:00:09
 *
 */
public class NumberTools {
	/**
	 * 6位整数
	 * @return
	 */
	public static int sixBitNumbers(){
		return (int) ((Math.random()*9+1)*100000);
	}
	/**
	 * 5位整数
	 * @return
	 */
	public static int fiveBitNumbers(){
		return (int)((Math.random()*9+1)*10000);
	}
	/**
	 * 4位整数
	 * @return
	 */
	public static int fourBitNumbers(){
		return (int)((Math.random()*9+1)*1000);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i< 1000; i++) {
			System.out.println((int) ((Math.random()*9+1)*100000));//6
			System.out.println((int)((Math.random()*9+1)*10000));//5位数  
			System.out.println((int)((Math.random()*9+1)*1000));  //4位数
		}
	}
}
