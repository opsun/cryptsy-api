package com.opsunv.cryptsy.utils;

public abstract class Assert {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||"".equals(str);
	}
	
	/**
	 * 多个参数，如果其中一个为空则为空
	 * @param strings
	 * @return
	 */
	public static boolean isEmpty(String... strings){
		for(String str:strings){
			if(isEmpty(str)) return true;
		}
		
		return false;
	}
	
}
