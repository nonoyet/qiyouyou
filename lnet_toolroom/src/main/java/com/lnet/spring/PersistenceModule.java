/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: PersistenceModule.java 15491 2011-06-22 05:17:57Z fuzhao $
 * created at:2010-03-11
 */

package com.lnet.spring;

import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ObjectLocator;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Scope;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.services.PerthreadManager;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import corner.cache.CacheSymbols;
import corner.orm.hibernate.HibernateEntityService;
import corner.orm.hibernate.impl.CacheHibernateEntityServiceImpl;
import corner.orm.hibernate.impl.EntityServiceImpl;
import corner.orm.hibernate.impl.HibernateEntityServiceImpl;
import corner.orm.hibernate.impl.SpringSessionManagerImpl;
import corner.orm.services.EntityService;


/**
 * persistence core module
 * 
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 15491 $
 * @since 0.1
 */
public class PersistenceModule {
	// bind service
	public static void bind(ServiceBinder binder) {
		binder.bind(HibernateEntityService.class, HibernateEntityServiceImpl.class);
	}

	// build gobal entity service
	public static EntityService buildEntityService(@Symbol(CacheSymbols.ENABLE_CACHE)
	boolean enableCache, ObjectLocator locator) {
		if (enableCache) {
			return (EntityService) locator.autobuild(CacheHibernateEntityServiceImpl.class);
		} else {
			return locator.autobuild(EntityServiceImpl.class);
		}
	}

	// build hibernate template object
	public static HibernateTemplate buildHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate template = new HibernateTemplate(sessionFactory);
		return template;
	}

	/**
	 * 替换由HibernateModule提供的HibernateSessionManager
	 * 
	 * @param sessionSource
	 * @param perthreadManager
	 * @return
	 */
	@Scope(org.apache.tapestry5.ioc.ScopeConstants.PERTHREAD)
	public static HibernateSessionManager buildSpringSessionManager(HibernateSessionSource sessionSource, PerthreadManager perthreadManager) {
		SpringSessionManagerImpl service = new SpringSessionManagerImpl(sessionSource);
		perthreadManager.addThreadCleanupListener(service);
		return service;
	}

	/**
	 * 覆盖由Hibernate Module提供的HibernateSessionManager
	 * 
	 * @param manager
	 * @param configuration
	 */
	public static void contributeServiceOverride(MappedConfiguration<Class, Object> configuration, @Local
	HibernateSessionManager manager) {
		configuration.add(HibernateSessionManager.class, manager);
	}

	/**
	 * build spring platform transaction manager
	 * 
	 * @param sessionSource
	 *            session source
	 * @param session
	 * @return
	 * @since 0.0.2
	 */
	public static PlatformTransactionManager buildPlatformTransactionManager(HibernateSessionSource sessionSource) {
		HibernateTransactionManager platformTransactionManager = new HibernateTransactionManager();
		platformTransactionManager.setSessionFactory(sessionSource.getSessionFactory());
		platformTransactionManager.afterPropertiesSet();
		return platformTransactionManager;
	}
}
