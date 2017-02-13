package com.lnet.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听session创建，用于统计在线人数(包括平台和门户)
 * @author nonoyet
 * @version 2016-01-11
 */
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {

	
	public void sessionCreated(HttpSessionEvent se) {
//		
//		PtOnlineStatistics.increase();  
//		MhOnlineStatistics.increase();
	}

	
	public void sessionDestroyed(HttpSessionEvent se) {
		
//		PtOnlineStatistics.decrease(); 
//		MhOnlineStatistics.decrease(); 
	}
	
	/** 
     * 用户登录时 
     */  
    public void attributeAdded(HttpSessionBindingEvent se) {  
//        if ("accountSession".equals(se.getName())) {  
//            Account account = (Account) se.getValue();  
//            PtOnlineStatistics.addAttr(account);  
//            se.getSession().setMaxInactiveInterval(60 * 20);// 失效时间SEC * MINS  
//        }
//        if ("mhAccountSession".equals(se.getName())) {  
//            Account account = (Account) se.getValue();  
//            MhOnlineStatistics.addAttr(account);  
//            se.getSession().setMaxInactiveInterval(60 * 20);// 失效时间SEC * MINS  
//        }
    }  
  
    /** 
     * 用户退出登录(销毁session属性时) 
     */  
    public void attributeRemoved(HttpSessionBindingEvent se) {  
//        if ("accountSession".equals(se.getName())) {  
//        	Account account = (Account) se.getValue(); 
//            PtOnlineStatistics.removeAttr(account);  
//            account = null;  
//        }  
//        if ("mhAccountSession".equals(se.getName())) {  
//        	Account account = (Account) se.getValue(); 
//            MhOnlineStatistics.removeAttr(account);  
//            account = null;  
//        }  
    }  
  
    /** 
     * 待实现 
     */  
    public void attributeReplaced(HttpSessionBindingEvent se) {  
    	//to be extended  
    }  
}
