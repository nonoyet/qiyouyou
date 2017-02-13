package com.lnet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.egf.common.util.StringUtils;

/**
 * 读取系统配置文件
 * 
 * @author fuzhao
 * @version $Revision: 1.1 $
 * @since 0.1
 */
public class SysConfigPropertyUtil {
	private static final Log logger = LogFactory.getLog(SysConfigPropertyUtil.class);
	private static Map<String, SysConfigPropertyUtil> instanceMap = new HashMap<String, SysConfigPropertyUtil>();
	private static ReentrantLock locker = new ReentrantLock();
	private Properties properties;

	// 构造方法私有
	private SysConfigPropertyUtil(String file) {
		InputStream in = getClass().getResourceAsStream("/" + file);
		if (in != null) {
			properties = new Properties();
			try {
				properties.load(in);
			} catch (IOException e) {
				logger.error(e);
			} finally {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

	// 构造方法私有
	private SysConfigPropertyUtil(File file) {
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
				logger.error(e);
			} finally {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static SysConfigPropertyUtil getInstance() {
		return getInstance("");
	}

	public static SysConfigPropertyUtil getInstance(String file) {
		if (StringUtils.isBlank(file)) {
			if (!StringUtils.isBlank(ConfigurationUtils.COMPARE_CFG_DIR)) {// QINGBAO_CFG_DIR不为空
				File f = new File(ConfigurationUtils.COMPARE_CFG_DIR + ConfigurationUtils.FILE_SEPARATOR + ConfigurationUtils.APP_TYPE + ConfigurationUtils.FILE_SEPARATOR + "sysconfig.properties");
				if(f.exists()){
					return getInstance(f);
				}
			} else if (!StringUtils.isBlank(ConfigurationUtils.PLATFORM)) {// PLATFORM不为空
				file = ConfigurationUtils.PLATFORM + "/sysconfig.properties";
			} else {// 默认
				file = "sysconfig.properties";
			}
		}
		SysConfigPropertyUtil instance = instanceMap.get(file);
		if (instance == null) {
			try {
				locker.lock();
				if (instance == null) {
					instance = new SysConfigPropertyUtil(file);
					instanceMap.put(file, instance);
				}
			} finally {
				locker.unlock();
			}
		}
		return instance;
	}

	public static SysConfigPropertyUtil getInstance(File file) {
		SysConfigPropertyUtil instance = instanceMap.get(file.getName());
		if (instance == null) {
			try {
				locker.lock();
				if (instance == null) {
					instance = new SysConfigPropertyUtil(file);
					instanceMap.put(file.getName(), instance);
				}
			} finally {
				locker.unlock();
			}
		}
		return instance;
	}

	public String getPropertyValue(String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}
		if(properties!=null){
			String value = properties.getProperty(key);
			if(StringUtils.isBlank(value)){
				return null;
			}
			try {
				return new String(value.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
