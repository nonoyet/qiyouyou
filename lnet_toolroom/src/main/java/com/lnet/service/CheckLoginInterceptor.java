/**
 * 
 */
package com.lnet.service;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/** 
 * @Description: 验证登陆的拦截器类
 * @author nonoyet
 * @version 2016-08-11
 */
public class CheckLoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2007948185143701946L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<?,?> session = invocation.getInvocationContext().getSession();//获取session
		if(session.get("accountSession") == null) {//没找到登陆账号信息
			return "not_login";
		}else{
			return invocation.invoke();//继续调用
		}
	}

}
