package com.lnet.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egf.common.util.StringUtils;

public class BeanUtil {
	
	static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	/**
	 * bean对象转换成map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> convertObjectToMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (obj == null) {
			return map;
		}

		PropertyDescriptor[] objPds = PropertyUtils.getPropertyDescriptors(obj);

		for (PropertyDescriptor pd : objPds) {
			if (!"class".equals(pd.getName())) {
				String methodName = "get" + StringUtils.capitalize(pd.getName());
				try {
					Object rsObj = MethodUtils.invokeMethod(obj, methodName, null);
					map.put(pd.getName(), rsObj);
				} catch (NoSuchMethodException e) {
					logger.error(e.getMessage());
				} catch (IllegalAccessException e) {
					logger.error(e.getMessage());
				} catch (InvocationTargetException e) {
					logger.error(e.getMessage());
				}
			}
		}

		// System.out.println(JSONUtil.toJson(map));

		return map;
	}
	
	/**
	 * bean对象转换成map，与上面不同的是如果该实体中有其它实体对象属性的话则用其id代替，
	 * 		如DisplayConfig中有checkProject属性，则checkProject=checkProject.getId()
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> convertObjectToMap2(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (obj == null) {
			return map;
		}

		PropertyDescriptor[] objPds = PropertyUtils.getPropertyDescriptors(obj);

		for (PropertyDescriptor pd : objPds) {
			if (!"class".equals(pd.getName())) {
				String methodName = "get" + StringUtils.capitalize(pd.getName());
				try {
					Object rsObj = MethodUtils.invokeMethod(obj, methodName, null);
					if(rsObj != null && !(rsObj instanceof Object[])) {
						String packageName = rsObj.getClass().getPackage().getName().trim();	//获取该对象包名
						if("com.lnet.qingbao.qwbk.entities".equalsIgnoreCase(packageName))	//说明该属性为对象属性，且类型为实体类，则将其值改为其id
							map.put(pd.getName(), MethodUtils.invokeMethod(rsObj, "getId", null));	//将值用id值代替
						else if("org.hibernate.collection".equalsIgnoreCase(packageName) || "com.lnet.qa.model".equalsIgnoreCase(packageName))
							map.put(pd.getName(), null);
						else {
							map.put(pd.getName(), rsObj);
						}
					}else if(rsObj instanceof Object[]){
						map.put(pd.getName(), null);	//不允许显示数组
					}else{
						map.put(pd.getName(), rsObj);
					}
				} catch (NoSuchMethodException e) {
					logger.error(e.getMessage());
				} catch (IllegalAccessException e) {
					logger.error(e.getMessage());
				} catch (InvocationTargetException e) {
					logger.error(e.getMessage());
				}
			}
		}

		// System.out.println(JSONUtil.toJson(map));

		return map;
	}
}
