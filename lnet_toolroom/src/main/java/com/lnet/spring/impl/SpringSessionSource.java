/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: SpringSessionSource.java 9938 2010-11-01 08:40:12Z wangpf $
 * created at:2010-03-25
 */

package com.lnet.spring.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.apache.tapestry5.ioc.services.RegistryShutdownListener;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.lnet.util.ConfigurationUtils;

/**
 * 基于Spring管理的factory
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 9938 $
 * @since 0.1
 */
public class SpringSessionSource implements HibernateSessionSource,RegistryShutdownListener {

	private final SessionFactory sessionFactory;

    private final Configuration configuration;

	private AnnotationSessionFactoryBean sessionFactoryBean;

    public SpringSessionSource(final List<HibernateConfigurer> hibernateConfigurers, LobHandler lobHandler)
    {
    	
    	sessionFactoryBean = new AnnotationSessionFactoryBean(){
			/**
			 * @see org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean#postProcessAnnotationConfiguration(org.hibernate.cfg.AnnotationConfiguration)
			 */
			@Override
			protected void postProcessAnnotationConfiguration(
					AnnotationConfiguration configuration) throws HibernateException {
				 for (HibernateConfigurer configurer : hibernateConfigurers)
			            configurer.configure(configuration);
			}
    	};
    	
    	Resource resource = null;
    	if(!StringUtils.isBlank(ConfigurationUtils.COMPARE_CFG_DIR)){//QINGBAO_CFG_DIR 不为空
    		File file = new File(ConfigurationUtils.COMPARE_CFG_DIR + ConfigurationUtils.FILE_SEPARATOR + ConfigurationUtils.APP_TYPE + ConfigurationUtils.FILE_SEPARATOR + "hibernate.cfg.xml");
    		resource = new FileSystemResource(file);
    	}else if(!StringUtils.isBlank(ConfigurationUtils.PLATFORM)){//PLATFORM 不为空
    		resource = new ClassPathResource(ConfigurationUtils.PLATFORM+"/hibernate.cfg.xml");
    	}else{//默认
    		resource = new ClassPathResource("hibernate.cfg.xml");
    	}
    	sessionFactoryBean.setConfigLocation(resource);
		sessionFactoryBean.setLobHandler(lobHandler);
		sessionFactoryBean.setSchemaUpdate(false);
    	try {
			sessionFactoryBean.afterPropertiesSet();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
        sessionFactory = (SessionFactory) sessionFactoryBean.getObject();
        this.configuration = sessionFactoryBean.getConfiguration();

    }

    public Session create()
    {
        return sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }

    public void registryDidShutdown()
    {
    	sessionFactoryBean.destroy();
    }

}
