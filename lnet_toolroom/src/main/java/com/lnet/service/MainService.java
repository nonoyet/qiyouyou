package com.lnet.service;

import java.util.List;

import org.hibernate.classic.Session;
import org.hibernate.transform.ResultTransformer;

import base.service.BaseService;

public interface MainService extends BaseService {

	/**
	 * 根据sql获取实体对象	
	 * @param sql
	 * sql语句
	 * @param cls
	 * 	实体类型
	 * @return
	 */
	public List<?> findSql(String sql,Class<?> cls);
	/**
	 * 根据sql查询出实体bean对象
	 * @param sql
	 * @param params
	 * 		参数数组
	 * @param orderBy
	 * 		排序字段数组
	 * @param order
	 * 		排序方式数组
	 * @param curPage
	 * 		当前页
	 * @param pageSize
	 * 		每页大小
	 * @param cls
	 * 		返回bean类型
	 * @return
	 */
	public List<?> findSql(String sql, Object[] params, String[] orderBy, String[] order, int curPage, int pageSize,Class<?> cls);
	/**
	 * 查询结果转换为指定的模型返回
	 * @param sql
	 * @param params
	 * @param orderBy
	 * @param order
	 * @param index
	 * @param size
	 * @param transformer
	 * 	模型转换器
	 * @return
	 */
	public List<?> findSQL(String sql, final Object[] params, final String[] orderBy, final String[] order, final int index, final int size, final ResultTransformer transformer);
	/**
	 * 创建数据库链接session
	 * @return
	 */
	public Session openSession();
	
	/**
	 * 根据sql获取实体对象(创建线程session)	
	 * @param sql
	 * sql语句
	 * @param cls
	 * 	实体类型
	 * @return
	 */
	public List<?> findSqlWithOpenSession(Session session,String sql,Class<?> cls);
	/**
	 * 保存实体
	 * @param session
	 * @param obj
	 */
	public void save(Session session,Object obj);
	
	
}
