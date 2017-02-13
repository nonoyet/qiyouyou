/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: XmlEntityPackageManager.java 6312 2010-06-10 07:31:06Z fuzhao $
 * created at:2010-03-11
 */

package com.lnet.spring;

import java.util.Collection;

import org.apache.tapestry5.ioc.annotations.UsesConfiguration;

/**
 * xml hibernate mapping package manager
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 6312 $
 * @since 0.1
 */
@UsesConfiguration(String.class)
public interface XmlEntityPackageManager {

	/**
	 * get package names
	 * @return get xml package names
	 * @since 0.1
	 */
	Collection<String> getPackageNames();

}
