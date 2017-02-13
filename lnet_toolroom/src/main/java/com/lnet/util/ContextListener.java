package com.lnet.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class ContextListener extends HttpServlet
implements ServletContextListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContextListener() {
	}
	/**
	 * 初始化
	 */
	public void contextInitialized(ServletContextEvent event) {

	}
	/**
	 * 结束
	 */
	public void contextDestroyed(ServletContextEvent event) {
	    
	    
	}
	
	

}
