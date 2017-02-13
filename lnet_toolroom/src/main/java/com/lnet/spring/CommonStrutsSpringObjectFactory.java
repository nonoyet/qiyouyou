/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010/02/03 07:49:58 fuzhao Exp $
 * created at:2010-3-24
 */
package com.lnet.spring;

import org.springframework.context.ApplicationContext;

import com.lnet.util.ConfigurationUtils;
import com.opensymphony.xwork2.spring.SpringObjectFactory;

/**
 * 提供spring的对象给Struts2使用
 * @author yangjm
 * @version $Revision: 1.0.0 $
 * @since 0.1
 */
public class CommonStrutsSpringObjectFactory  extends SpringObjectFactory {
	private static final long serialVersionUID = 5704395898212776022L;
	
	public CommonStrutsSpringObjectFactory(){
		//设置系统配置资源类路径到qingbao.cfg.dir全局常量
		ConfigurationUtils.COMPARE_CFG_DIR = ConfigurationUtils.getConfigResourcePath();
		//设置平台资源类路径到ConfigurationUtils.PLATFORM全局常量
		ConfigurationUtils.PLATFORM = ConfigurationUtils.getPlatform(ConfigurationUtils.getQingbaoPlatformFilePath());
		//设置log4j.properties文件所在类路径
		ConfigurationUtils.setLog4jFilePath(ConfigurationUtils.APP_CFG_FILE_NAME_COMPARE);
		ApplicationContext ac = SpringContext.getApplicationContext();
		this.setApplicationContext(ac);
	}
}
