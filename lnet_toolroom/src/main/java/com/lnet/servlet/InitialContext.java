package com.lnet.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import base.common.constant.SSHConstant;

import com.lnet.service.impl.CommonServiceImpl;
import com.lnet.spring.Container;
import com.lnet.spring.SpringContext;

/**
 * 初始化服务器web容器
 * 
 * @author fuzhao
 * @version $Revision: 1.1 $
 * @since 0.1
 */
public class InitialContext extends base.web.servlet.InitialContext {
	private final Log logger = LogFactory.getLog(getClass());
	private ServletConfig config;
	protected ServletContext context;
	private CommonServiceImpl commonServiceImpl = SpringContext.getBean(CommonServiceImpl.class, "commonService");
	 protected HttpServletRequest request;
	public void destroy() {
		logger.info("关闭容器.......");
		SSHConstant.CodeMap = null;
		SpringContext.shutdown();
		Container.shutdown();
	}
	
	/**
	 * 初始化
	 * 
	 */
	public void init(ServletConfig arg0) throws ServletException {
		this.config = arg0;
		this.context = config.getServletContext();
		super.init(arg0);
	}

	public ServletConfig getConfig() {
		return config;
	}

	public void setConfig(ServletConfig config) {
		this.config = config;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	

	
}