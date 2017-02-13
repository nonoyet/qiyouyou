/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: XmlEntityPackageHibernateConfigurer.java 6312 2010-06-10 07:31:06Z fuzhao $
 * created at:2010-03-11
 */

package com.lnet.spring.impl;

import java.util.Collection;

import javax.persistence.Entity;

import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.apache.tapestry5.ioc.services.ClassNameLocator;
import org.hibernate.cfg.Configuration;

import com.lnet.spring.XmlEntityPackageManager;

/**
 * xml entity package configuration
 * 
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 6312 $
 * @since 0.1
 */
public class XmlEntityPackageHibernateConfigurer implements HibernateConfigurer {
	private ClassNameLocator classNameLocator;
	private XmlEntityPackageManager packageManager;

	public XmlEntityPackageHibernateConfigurer(final ClassNameLocator classNameLocator, XmlEntityPackageManager packageManager) {
		this.classNameLocator = classNameLocator;
		this.packageManager = packageManager;
	}

	/**
	 * @see org.apache.tapestry5.hibernate.HibernateConfigurer#configure(org.hibernate.cfg.Configuration)
	 */
	public void configure(Configuration configuration) {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		Collection<String> packageNames = packageManager.getPackageNames();
		for (String packageName : packageNames) {
			for (String className : classNameLocator.locateClassNames(packageName)) {
				try {
					Class entityClass = contextClassLoader.loadClass(className);
                    if(entityClass.isAnnotationPresent(Entity.class)){
//                        configuration.addAnnotatedClass(entityClass);
                    }
				} catch (ClassNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
	}

}
