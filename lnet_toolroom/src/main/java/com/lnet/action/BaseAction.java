package com.lnet.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import base.service.BaseService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 基础Action BaseAction
 * @author yangjm
 * @version 1.0.0
 * 
 */
@Controller("baseAction")
@Scope("prototype")
public abstract class BaseAction extends ActionSupport implements ApplicationContextAware, SessionAware,
        ServletRequestAware, ServletResponseAware, ServletContextAware, ServletConfigAware, ParameterAware {

    private static final long serialVersionUID = 175018348194126881L;
    protected final Logger logger = Logger.getLogger(getClass());
    private ApplicationContext application;
    protected Map<String, Object> session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private ServletContext context;
    @SuppressWarnings("unused")
    private ServletConfig config;
    @SuppressWarnings("unused")
    private Map<String, String[]> parameter;
    protected BaseService service;
    
    /** businessSession */
    private static final String BUSINESS_SESSION = "BUSINESS_DATA";
    

    /** 下载文件显示的名字 */
    protected String downloadFileDisplayName = "";
    /** 下载文件路径和名字 */
    protected String downloadFileFullName = "";
    /** 下载文件类型 */
    protected String downloadFileContentType = "";
    /** 下载文件后是否删除 */
    protected boolean downloadAfterDeleteFlg = false;

    /** 上传文件对象 */
    protected File[] uploadFileData;
    /** 上传文件名 */
    protected String[] uploadFileDataFileName;
    /** 上传文件类型 */
    protected String[] uploadFileDataContentType;
    
	@Resource
	public void setService(BaseService service) {
		this.service = service;
	}

    /*
     * (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    public final void setApplicationContext(ApplicationContext application) throws BeansException {
        this.application = application;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
     */
    public final void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
     */
    public final void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse
     * (javax.servlet.http.HttpServletResponse)
     */
    public final void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.util.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */
    public final void setServletContext(ServletContext context) {
        this.context = context;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.util.ServletConfigAware#setServletConfig(javax.servlet.ServletConfig)
     */
    public final void setServletConfig(ServletConfig config) {
        this.config = config;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts2.interceptor.ParameterAware#setParameters(java.util.Map)
     */
    public final void setParameters(Map<String, String[]> parameter) {
        this.parameter = parameter;
    }

    /**
     * 取得bean对象
     * 
     * @param beanName
     * @return
     */
    public final Object getObject(String beanName) {
        return application.getBean(beanName);
    }

    /**
     * 取得绝对路径
     * 
     * @param path
     * @return
     */
    public final String getRealPath(String path) {
        return context.getRealPath(path);
    }

    /**
     * 取得客户端IP地址ַ
     * 
     * @return 客户端IP地址
     */
    public final String getRemoteAddr() {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    // ==========session========== //

    /**
     * 往SystemSession中放值
     * 
     * @param key
     * @param value
     */
    public final void setValueToSystemSession(String key, Object value) {
        this.session.put(key, value);
    }

    /**
     * 从SystemSession中取值
     * 
     * @param <T>
     * @param key
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public final <T> T getValueFromSystemSession(String key, Class<T> clazz) {
        return (T) this.session.get(key);
    }

    /**
     * 从SystemSession中取值
     * 
     * @param key
     * @return
     */
    public final Object getValueFromSystemSession(String key) {
        return this.session.get(key);
    }

    /**
     * 从SystemSession中移除对象
     * 
     * @param key
     * @return
     */
    public final Object removeFromSystemSession(String key) {
        return this.session.remove(key);
    }

    /**
     * 往BusinessSession中放值
     * 
     * @param key
     * @param value
     */
    @SuppressWarnings("unchecked")
    public final void setValueToBusinessSession(String key, Object value) {
        if (this.session.get(BUSINESS_SESSION) == null) {
            Map<String, Object> businessSession = new HashMap<String, Object>();
            businessSession.put(key, value);
            this.session.put(BUSINESS_SESSION, businessSession);
        } else {
            ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION)).put(key, value);
        }
    }

    /**
     * 从BusinessSession中取值
     * 
     * @param <T>
     * @param key
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public final <T> T getValueFromBusinessSession(String key, Class<T> clazz) {
        Map<String, Object> sysSession = ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION));
        if (sysSession != null) {
            return (T) sysSession.get(key);
        } else {
            return null;
        }
    }

    /**
     * 从BusinessSession中取值
     * 
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public final Object getValueFromBusinessSession(String key) {
        Map<String, Object> sysSession = ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION));
        if (sysSession != null) {
            return sysSession.get(key);
        } else {
            return null;
        }
    }

    /**
     * 从BusinessSession中移除对象
     * 
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public final Object removeFromBusinessSession(String key) {
        Map<String, Object> sysSession = ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION));
        if (sysSession != null) {
            return ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION)).remove(key);
        } else {
            return null;
        }
    }

    /**
     * 清空BusinessSession
     */
    @SuppressWarnings("unchecked")
    public final void clearBusinessSession() {
        Map<String, Object> sysSession = ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION));
        if (sysSession != null) {
            ((HashMap<String, Object>) this.session.get(BUSINESS_SESSION)).clear();
        }
    }

    /**
     * 取得SystemSession
     * 
     * @return
     */
    public Map<String, Object> getSystemSession() {
        return this.session;
    }

    /**
     * 取得BusinessSession
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getBusinessSession() {
        return (HashMap<String, Object>) this.session.get(BUSINESS_SESSION);
    }

    /**
     * 使session失效
     */
    protected void invalidateSession() {
        this.request.getSession().invalidate();
    }

    // ==========request========== //

    /**
     * 从request中取参数值
     * 
     * @param key
     * @return
     */
    public final String getParameterFromRequest(String key) {
        return this.request.getParameter(key);
    }

    /**
     * 获取request中的属性值
     * 
     * @param attName 属性名
     * @return
     */
    public final Object getAttributeFromRequest(String attName) {
        return this.request.getAttribute(attName);
    }

    // ==========download========== //

    /**
     * @return the downloadFileContentType
     */
    public String getDownloadFileContentType() {
        return downloadFileContentType;
    }

    /**
     * @param downloadFileContentType the downloadFileContentType to set
     */
    public void setDownloadFileContentType(String downloadFileContentType) {
        this.downloadFileContentType = downloadFileContentType;
    }

    /**
     * @return the downloadFileFullName
     */
    public String getDownloadFileFullName() {
        return downloadFileFullName;
    }

    /**
     * @param downloadFileFullName the downloadFileFullName to set
     */
    public void setDownloadFileFullName(String downloadFileFullName) {
        this.downloadFileFullName = downloadFileFullName;
    }

    /**
     * @return the downloadFileDisplayName
     */
    public String getDownloadFileDisplayName() {
        return downloadFileDisplayName;
    }

    /**
     * @param downloadFileDisplayName the downloadFileDisplayName to set
     */
    public void setDownloadFileDisplayName(String downloadFileDisplayName) {
        this.downloadFileDisplayName = downloadFileDisplayName;
    }

    /**
     * @return the downloadAfterDeleteFlg
     */
    public boolean isDownloadAfterDeleteFlg() {
        return downloadAfterDeleteFlg;
    }

    /**
     * @param downloadAfterDeleteFlg the downloadAfterDeleteFlg to set
     */
    public void setDownloadAfterDeleteFlg(boolean downloadAfterDeleteFlg) {
        this.downloadAfterDeleteFlg = downloadAfterDeleteFlg;
    }



    public File[] getUploadFileData() {
		return uploadFileData;
	}

	public void setUploadFileData(File[] uploadFileData) {
		this.uploadFileData = uploadFileData;
	}

	public String[] getUploadFileDataFileName() {
		return uploadFileDataFileName;
	}

	public void setUploadFileDataFileName(String[] uploadFileDataFileName) {
		this.uploadFileDataFileName = uploadFileDataFileName;
	}

	public String[] getUploadFileDataContentType() {
		return uploadFileDataContentType;
	}

	public void setUploadFileDataContentType(String[] uploadFileDataContentType) {
		this.uploadFileDataContentType = uploadFileDataContentType;
	}

	/*
     * (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    public final String execute() throws Exception {
        super.execute();
        return this.doExecute();
    }

    public String doExecute() throws Exception {
        return SUCCESS;
    }
    
}
