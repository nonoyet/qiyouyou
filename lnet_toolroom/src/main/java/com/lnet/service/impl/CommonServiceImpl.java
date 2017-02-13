package com.lnet.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.tapestry5.ioc.services.RegistryShutdownHub;
import org.apache.tapestry5.ioc.services.RegistryShutdownListener;
import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

import base.service.impl.BaseServiceImpl;


public class CommonServiceImpl extends BaseServiceImpl {
    protected HttpServletRequest request;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	 protected Map<String, Object> session;

	/**
	 * 根据sql语句进行分页查询(<span style="color:red;">对应的查询参数不能加上单引号,比如name=?而不是name='?'，否则会报错</span>)
	 * @param hql
	 * @param params
	 * @param orderBy
	 * @param order
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public List<?> findSql(String hql, Object[] params, String[] orderBy, String[] order, int curPage, int pageSize) {
		int offset = (curPage - 1) * pageSize + 1;
		int limit = pageSize;
		return dao.findSQL(hql, params, orderBy, order, offset - 1, limit);
	}
	/**
	 * Hql统计
	 * @param hql
	 * @param params
	 * 		参数数组
	 * @return
	 */
	public int count(String hql, Object[] params) {
		return dao.count(hql, params);
	}
	/**
	 * 根据hql统计
	 * @param hql
	 * @return
	 */
	public int count(String hql) {
		return dao.count(hql);
	}
	/**
	 * 根据sql统计
	 * @param sql
	 * @return
	 */
	public int countSql(String sql) {
		return dao.countSQL(sql);
	}
	/**
	 * 根据sql统计
	 * @param sql
	 * @param params
	 * 		参数数组
	 * @return
	 */
	public int countSql(String sql, Object[] params) {
		return dao.countSQL(sql, params);
	}
	/**
	 * 合并保存
	 * @param obj 保存的对象
	 */
	public void merge(Object obj) {
		dao.merge(obj);
	}
	
	public DataSource buildDataSource(RegistryShutdownHub shutdownHub, String jdbcUser, String jdbcPassword,
			String jdbcDriverClass, String jdbcUrl) {
		
	  final String poolName = "qwpool" + jdbcUser;
	  Properties info = new Properties();
	  info.setProperty("jdbc-x.proxool.alias", poolName);
	  info.setProperty("jdbc-x.proxool.maximum-connection-count", "50");
	  info.setProperty("jdbc-x.user", jdbcUser);
	  if (jdbcPassword != null) {
	    info.setProperty("jdbc-x.password", jdbcPassword);
	  }
	  info.setProperty("jdbc-x.proxool.driver-class", jdbcDriverClass);
	  info.setProperty("jdbc-x.proxool.driver-url", jdbcUrl);
	
	  //configuration proxool database source
	  final String[] pools = ProxoolFacade.getAliases();
	  boolean flag = false;
	  for(int i=0; i<pools.length; i++) {
		  if(pools[i].equals(poolName)) {
			  flag = true;
			  break;
		  }
	  }
	  if(flag == false) {
		  try {
			PropertyConfigurator.configure(info);
		} catch (ProxoolException e) {
			e.printStackTrace();
		}
	  }
	  //new datasource
	  DataSource ds = new ProxoolDataSource(poolName);
	  //register to shutdown
	  shutdownHub.addRegistryShutdownListener(new RegistryShutdownListener() {
	    public void registryDidShutdown() {
	    	boolean contains = false;
	    	for(int j=0; j<pools.length; j++) {
	    		if(pools[j].equals(poolName)) {
	    			contains = true;
	    			break;
	    		}
	    	}
	    	if(contains == true) {
	    		try {
					ProxoolFacade.removeConnectionPool(poolName);
				} catch (ProxoolException e) {
					e.printStackTrace();
				}
	    	}
	    }
	  });
	  return ds;
	  
	  
	}
	
    /**
     * 批量更新
     * @param dataList
     * @param batchSize
     */
    public void batchUpdate(List<?> dataList, int batchSize) {
    	dao.batchUpdate(dataList, batchSize);
    }
    /**
     * 初始化查询表
     * @return
     */
    public Map<String, String> initOfficeMap() {
    	List<?> czdmList = dao.findSQL("select idcard,REAL_NAME from users");
    	Map<String, String> czdmMap = new HashMap<String, String>();
    	for(int i=0; i<czdmList.size(); i++) {
    		Object[] obj = (Object[])czdmList.get(i);
    		czdmMap.put(String.valueOf(obj[0]), String.valueOf(obj[1]));
    	}
    	return czdmMap;
    }
   
    
    
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
 
    
}
