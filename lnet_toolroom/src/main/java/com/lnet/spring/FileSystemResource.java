/*		
 * Copyright 2010 The EGF Co., Ltd. 
 * site: http://www.egfit.com
 * file: $Id: org.eclipse.jdt.ui.prefs,v 1.1 2010 2010-11-1 fangj Exp $
 * created at:2010-11-1
 */
package com.lnet.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import org.apache.tapestry5.ioc.Resource;

/**
 * 基于文件系统的Resource实现
 * @author wpf
 * @version $Revision: 1.1 $
 * @since 0.1
 */
public class FileSystemResource implements Resource {
	
	private File file ; 
	
	public FileSystemResource(File file){
		this.file = file;
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#exists()
	 */
	public boolean exists() {
		return file.exists();
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#forFile(java.lang.String)
	 */
	public Resource forFile(String arg0) {
		return null;
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#forLocale(java.util.Locale)
	 */
	public Resource forLocale(Locale arg0) {
		return null;
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#getFile()
	 */
	public String getFile() {
		return file.getName();
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#getFolder()
	 */
	public String getFolder() {
		return file.getPath();
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#getPath()
	 */
	public String getPath() {
		return file.getPath();
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#openStream()
	 */
	public InputStream openStream() throws IOException {
		return new FileInputStream(file);
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#toURL()
	 */
	public URL toURL() {
		try {
			return file.toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see org.apache.tapestry5.ioc.Resource#withExtension(java.lang.String)
	 */
	public Resource withExtension(String arg0) {
		return null;
	}

}
