/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: SystemModule.java 18774 2011-08-25 09:43:08Z yangjm $
 * created at:2010-03-11
 */

package com.lnet.spring;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.tapestry5.hibernate.HibernateConfigurer;
import org.apache.tapestry5.hibernate.HibernateSessionSource;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.ioc.annotations.ServiceId;
import org.apache.tapestry5.ioc.services.RegistryShutdownHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.jdbc.support.lob.OracleLobHandler;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.jdbc.support.nativejdbc.SimpleNativeJdbcExtractor;

import com.egf.common.util.SysConfigPropertyUtil;
import com.lnet.spring.impl.SpringSessionSource;
import com.lnet.spring.impl.XmlEntityPackageHibernateConfigurer;

import corner.transaction.services.TransactionAdvisor;
/**
 * system module
 * 
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 18774 $
 * @since 0.1
 */
public class SystemModule {
	private static SysConfigPropertyUtil sysUtil = SysConfigPropertyUtil.getInstance();
	private static Logger logger = LoggerFactory.getLogger(SystemModule.class);
	public static void contributeXmlEntityPackageManager(Configuration<String> configuration) {
		String loadEntityPackage = sysUtil.getPropertyValue("LoadEntityPackage");
		logger.info("准备开始加载实体...");
		if (StringUtils.isBlank(loadEntityPackage)) {
			//configuration.add("com.egf.qa.entities");
		} else {
			String[] loadEntityPackages = loadEntityPackage.split("/");
			for (String packageName : loadEntityPackages) {
				configuration.add(packageName);
			}
		}
	}

	public static void bind(ServiceBinder binder) {
		binder.bind(NativeJdbcExtractor.class, SimpleNativeJdbcExtractor.class);
	}

	public LobHandler buildLobHandler(@Local NativeJdbcExtractor extractor, NativeJdbcExtractor nativeJdbcExtractor) {
		OracleLobHandler handler = new OracleLobHandler();
		handler.setNativeJdbcExtractor(nativeJdbcExtractor);
		return handler;
	}

	@ServiceId("SpringSessionSource")
	public static HibernateSessionSource buildHibernateSessionSource(Logger logger, List<HibernateConfigurer> config, RegistryShutdownHub hub, LobHandler lobHandler) {
		SpringSessionSource hss = new SpringSessionSource(config, lobHandler);
		hub.addRegistryShutdownListener(hss);

		return hss;
	}

	@Match({"*Receiver","*Transition"})
	public void adviseTransaction(MethodAdviceReceiver receiver, TransactionAdvisor transactionAdvisor) {
		transactionAdvisor.addTransactionCommitAdvice(receiver);
	}

	public static void contributeServiceOverride(MappedConfiguration<Class, Object> configuration, @Local HibernateSessionSource sessionSource) {
		configuration.add(HibernateSessionSource.class, sessionSource);
	}

	public static XmlEntityPackageManager buildXmlEntityPackageManager(final Collection<String> packageNames) {
		return new XmlEntityPackageManager() {
			public Collection<String> getPackageNames() {
				return packageNames;
			}
		};
	}

	public static void contributeSpringSessionSource(OrderedConfiguration<HibernateConfigurer> config) {
		config.addInstance("XmlEntityPackageManager", XmlEntityPackageHibernateConfigurer.class);
	}


}
