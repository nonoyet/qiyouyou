/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010/02/03 07:49:58 fuzhao Exp $
 * created at:2010-3-24
 */
package com.lnet.spring;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

/**
 * 覆盖默认的OSIV模式
 * @author yangjm
 * @version $Revision: 1.1 $
 * @since 0.1
 */
public class CommonOpenSessionInViewFilter extends OpenSessionInViewFilter{

	private static final String SESSION_FACTORY_BEAN_NAME = "sessionFactory";

	/* (non-Javadoc)
	 * @see org.springframework.orm.hibernate3.support.OpenSessionInViewFilter#lookupSessionFactory()
	 */
	@Override
	protected SessionFactory lookupSessionFactory() {
 		return SpringContext.getBean(SessionFactory.class,SESSION_FACTORY_BEAN_NAME);
	}
}
