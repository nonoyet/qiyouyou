/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: Container.java 6312 2010-06-10 07:31:06Z fuzhao $
 * created at:2010-03-11
 */

package com.lnet.spring;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.tapestry5.hibernate.HibernateCoreModule;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;

import corner.config.ConfigurationModule;
import corner.orm.OrmModule;
import corner.transaction.TransactionModule;

/**
 * object container
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 6312 $
 * @since 0.1
 */
public final class Container {
	//singleton container
	private static Container container=null;
	private static ReentrantLock lock = new ReentrantLock();
	/**
	 * get singleton container instance
	 * @return container instance 
	 * @since 0.1
	 */
	public static Container getInstance(){
		if(container== null){
			try{
				lock.lock();
				if(container== null){
					container= new Container();
				}
			}finally{
				lock.unlock();
			}
		}
		return container;
	}
	public static void shutdown(){
		if(container!=null&&container.registry!=null){
			container.registry.shutdown();
		}
	}
	/**
	 * get singleton container instance
	 * @return container instance 
	 * @since 0.1
	 */
	public static Container getInstance(Class... moduleClasses){
		if(container== null){
			try{
				lock.lock();
				if(container== null){
					container= new Container(moduleClasses);
				}
			}finally{
				lock.unlock();
			}
		}
		return container;
	}
	//global object container
	private Registry registry;
	
	private Container(){
		initRegistry();
	}
	/**
	 * @param moduleClasses
	 */
	public Container(Class... moduleClasses) {
		initRegistry(moduleClasses);
	}
	private void initRegistry(Class... moduleClasses){
		RegistryBuilder builder = new RegistryBuilder();
		builder.add(
				//hibernate core module
				HibernateCoreModule.class,
				//for transaction 
				TransactionModule.class,
				//for orm module
				OrmModule.class,
				//confguration module
				ConfigurationModule.class,
				//for service module
				ServiceModule.class);
		//other module class
		builder.add(moduleClasses);
		//build registry instance
        registry = builder.build();
        registry.performRegistryStartup();
	}
	/**
	 * get service instance 
	 * @param class service interface class
	 * @since 0.1
	 */
	public <T> T getService(Class<T> serviceInterface) {
		return registry.getService(serviceInterface);
	}
	/**
	 * 得到一个服务
	 * @param serviceInterface 服务接口
	 * @param serviceId 服务的ID
	 * @return 服务的实例
	 * @since 0.1
	 */
	public <T> T getService(Class<T> serviceInterface, String serviceId) {
		return registry.getService(serviceId, serviceInterface);
	}
}
