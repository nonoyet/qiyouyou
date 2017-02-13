package com.lnet.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 与页面展示相关的工具类
 * @author nonoyet
 * @version 2015-12-01
 *
 */
public class PageShowUtil {
	
	/**
	 * 将结果转换成页面所需json参数数组
	 * @param list
	 * @param OrgLevel
	 * @return
	 */
	public static JSONArray getPageShowValue(List<Map<String, Object>> list) {
		JSONArray array = new JSONArray();
		if (null == list || 0 == list.size()) {
			return array;
		}
		for (Map<String, Object> m : list) {
			JSONObject jsonObject = new JSONObject();
			for (String k : m.keySet()) {
				jsonObject.put(k, m.get(k));
			}
			array.add(jsonObject);
		}
		//System.out.println("json数组:" + array.toString());

		return array;
	}
	
}
