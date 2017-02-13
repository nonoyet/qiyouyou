/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010/02/03 07:49:58 fangjie Exp $
 * created at:2011-8-15
 */
package com.lnet.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
/**
 * 替换Spring中默认的事务管理
 * 
 * @author yangjm
 * @version $Revision: 1.0.0 $
 * @since 0.1
 */
public class ContainerIntergrationTransactionManager implements FactoryBean {

	public Object getObject() throws Exception {
		PlatformTransactionManager transactionManager = Container.getInstance().getService(PlatformTransactionManager.class);
		return transactionManager;
	}

	public Class<?> getObjectType() {
		return PlatformTransactionManager.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
