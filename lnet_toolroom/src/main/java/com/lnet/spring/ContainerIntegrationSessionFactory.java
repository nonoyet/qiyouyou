/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010/02/03 07:49:58 fuzhao Exp $
 * created at:2010-3-25
 */
package com.lnet.spring;

import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
/**
 * sessionFactory
 * @author yangjm
 * @version $Revision: 1.0.0 $
 * @since 0.1
 */
public class ContainerIntegrationSessionFactory implements FactoryBean{

	public Object getObject() throws Exception {
		HibernateSessionSource hss = Container.getInstance().
			getService(HibernateSessionSource.class,"SpringSessionSource");
		return hss.getSessionFactory();
	}

	public Class<?> getObjectType() {
		return SessionFactory.class;
	}
	public boolean isSingleton() {
		return true;
	}
}
