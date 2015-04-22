package com.znli.foodcomment.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
	/**
	 * sp操作的工具类
	 *    1. 保存数据: key---value
	 *    2. 得到数据: 根据key取对应的value
	 *    3. 移除数据: 根据key删除对应的key--vlaue
	 * 
	 * 
	 */
	public static final String USERNAME ="username";
	public static final String NICKNAME ="nickname";
	private static SharedPreferences sp;
	private static SpUtils instance = new SpUtils();

	private SpUtils() {
	}

	public static SpUtils getInstance(Context context) {
		if(sp==null) {
			sp = context.getSharedPreferences("food", Context.MODE_PRIVATE);
		}
		return instance;
	}
	
	/**
	 * 保存数据: key---value
	 * @param key
	 * @param value  String, int , boolean
	 */
	public void save(String key, Object value) {
		if(value instanceof String) {
			sp.edit().putString(key, (String) value).commit();
		} else if(value instanceof Integer) {
			sp.edit().putInt(key, (Integer) value).commit();
		} else if(value instanceof Boolean) {
			sp.edit().putBoolean(key, (Boolean) value).commit();
		} 
	}
	/**
	 * 得到字符串数据: 根据key取对应的value
	 * @param key
	 * @return
	 */
	public String getString(String key, String defValue) {
		return sp.getString(key, defValue);
	}
	
	/**
	 * 得到int数据: 根据key取对应的value
	 * @param key
	 * @return
	 */
	public int getInt(String key, int defValue) {
		return sp.getInt(key, defValue);
	}
	
	/**
	 * 得到boolean数据: 根据key取对应的value
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key, boolean defValue) {
		return sp.getBoolean(key, defValue);
	}
	
	
	/**
	 * 移除数据: 根据key删除对应的key--vlaue
	 * @param key
	 */
	public void remove(String key) {
		sp.edit().remove(key).commit();
	}
}



