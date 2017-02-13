/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010/02/03 07:49:58 fuzhao Exp $
 * created at:2010-3-24
 */
package com.lnet.spring;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Context 
 * @author yangjm
 * @version $Revision: 1.0.0 $
 * @since 0.1
 */
public class SpringContext {
	/** Spring Application Context **/
	private static ConfigurableApplicationContext applicationContext;
	// 所有的Spring配置文件在此添加
	private static final String [] CONTEXTS = new String[]{
		"classpath:action-servlet.xml",
		"classpath:base-service.xml",
		"classpath:base-dao.xml"
		};
	/** locker **/
	private static ReentrantLock locker = new ReentrantLock();
	/**
	 * 通过给定的Bean的名称来获取对应的Spring的管理实例对象
	 * @param beanName Spring Bean Name,eg: baseDao,xxxService
	 * @return Spring对象
	 */
	public static Object getBean(String beanName){
		return getApplicationContext().getBean(beanName);
	}
	/**
	 * 通过给定的Bean的名称来获取对应的Spring的管理实例对象
	 * @param beanName Spring Bean Name,eg: baseDao,xxxService
	 * @return Spring对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> objectClass,String beanName){
		return (T) getApplicationContext().getBean(beanName);
	}
	//Get Application Context or init context
	static ApplicationContext getApplicationContext(){
		if(applicationContext == null){
    		try{
    			locker.lock();
    			if(applicationContext == null){
    				//initilaize context
    				applicationContext = new ClassPathXmlApplicationContext(CONTEXTS);
    			}
    		}finally{
    			locker.unlock();
    		}
		}
		return applicationContext;
	}
	public static void shutdown() {
		if(applicationContext != null){
			//释放资源
			applicationContext.close();
		}
	}
}
