/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.2 2010/02/04 02:31:05 jcai Exp $
 * created at:2010-10-29
 */
package com.lnet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;

/**
 * 实现通用打包配置
 * 
 * @author yangjm
 * @version $Revision: 1.1 $
 * @since 0.1
 */
public class ConfigurationUtils {
	
	public static String PLATFORM = ""; // 平台代码
	public static String COMPARE_CFG_DIR = ""; // 配置文件路径
	public static String FILE_SEPARATOR = ""; // file.separator
	public static String APP_TYPE = ""; // APP_TYPE

	// 应用配置文件夹
	public static String APP_CFG_FILE_NAME_COMPARE = "compare";

	/**
	 * 获取配置资源路径
	 * 
	 * @return
	 * @since 0.1
	 */
	public static String getConfigResourcePath() {
		ConfigurationUtils.FILE_SEPARATOR = ConfigurationUtils.getFileSeparator();
		return System.getProperty("compare.cfg.dir");
	}

	/**
	 * 通过qingbao-platform.properties文件获取平台标识代码
	 * 
	 * @param path
	 * @return
	 * @since 0.1
	 */
	public static String getPlatform(String path) {
		String platform = "";
		Properties properties = null;
		File file = new File(path);
		if (file.exists()) {
			InputStream in = null;
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				throw new RuntimeException(e1);
			}
			if (in != null) {
				properties = new Properties();
				try {
					properties.load(in);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (properties != null) {
			platform = properties.getProperty("platform");
		}
		return platform;
	}
	
	/**
	 * 获取qingbao-platform.properties文件路径
	 * 
	 * @return
	 */
	public static String getQingbaoPlatformFilePath() {
		String rsPath = null;
		String separator = ConfigurationUtils.getFileSeparator();
		if ("\\".equals(separator)) {// windows
			rsPath = "C:\\compare-management.properties";
		} else if ("/".equals(separator)) {// like unix
			rsPath = "/home/weblogic/compare-management.properties";
		}
		return rsPath;
	}

	/**
	 * 获取("file.separator")
	 * 
	 * @return
	 * @since 0.1
	 */
	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * 设置log4j文件位置
	 * 
	 * @since 0.1
	 */
	public static void setLog4jFilePath(String appCfgFileName) {
		ConfigurationUtils.APP_TYPE = appCfgFileName;
		InputStream in = null;
		if (!StringUtils.isBlank(ConfigurationUtils.COMPARE_CFG_DIR)) {// QA_CFG_DIR 不为空
			File file = new File(ConfigurationUtils.COMPARE_CFG_DIR + ConfigurationUtils.FILE_SEPARATOR + ConfigurationUtils.APP_TYPE + ConfigurationUtils.FILE_SEPARATOR + "log4j.properties");
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				throw new RuntimeException(e1);
			}
		} else if (!StringUtils.isBlank(ConfigurationUtils.PLATFORM)) {// PLATFORM不为空
			in = ConfigurationUtils.class.getResourceAsStream("/" + ConfigurationUtils.PLATFORM + "/log4j.properties");
		} else {// 默认
			in = ConfigurationUtils.class.getResourceAsStream("/log4j.properties");
		}
		if (in != null) {
			Properties properties = new Properties();
			try {
				properties.load(in);
				PropertyConfigurator.configure(properties);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new RuntimeException("log4j.properties file can not find!");
		}
	}
}
