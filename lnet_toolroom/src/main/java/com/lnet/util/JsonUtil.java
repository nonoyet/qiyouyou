package com.lnet.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	
	static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	/**
	 * 将JSONObject转换为map
	 * @param jsonObj
	 * @return
	 */
	public static Map<String, Object> parseAsMap(JSONObject jsonObj) {
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		for (Iterator<?> iter=jsonObj.keys(); iter.hasNext();) {
	        String key = (String)iter.next();
	        map.put(key, jsonObj.getString(key));
		 }
		return map;
	}
	
	/**
	 * 转换成JSON字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		
		return createGson().toJson(obj);
	}
	/**
	 * 创建Gson
	 * 
	 * @return
	 */
	private static Gson createGson() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		// gsonBuilder.disableHtmlEscaping();
		gsonBuilder.serializeNulls();
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonBuilder.create();
		return gson;
	}
	
}
