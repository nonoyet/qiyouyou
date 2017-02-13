/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: ServiceModule.java 16900 2011-07-18 02:32:18Z yangjm $
 * created at:2010-03-11
 */

package com.lnet.spring;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.ioc.annotations.SubModule;

import corner.cache.CacheSymbols;
import corner.transaction.services.TransactionDecorator;

/**
 * service module
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 16900 $
 * @since 0.1
 */
@SubModule({PersistenceModule.class,SystemModule.class})
public class ServiceModule {
	public static void contributeFactoryDefaults(
			MappedConfiguration<String, String> configuration) {
		//默认不开启缓存
		configuration.add(CacheSymbols.ENABLE_CACHE,"false");
	}
	
	//所有以 Service结尾对象，要进行事务的配置说明
	@Match("*Service")
	public static <T> T decorateTransactionally(
			TransactionDecorator decorator, Class<T> serviceInterface,
			T delegate, String serviceId) {
		return decorator.build(serviceInterface, delegate, serviceId);
	}
}
