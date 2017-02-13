package com.lnet.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.transform.ResultTransformer;

import base.dao.handle.hibernate.BaseDAO;
import base.service.impl.BaseServiceImpl;

import com.lnet.service.MainService;

public class MainServiceImpl extends BaseServiceImpl implements MainService{
	
	
	/**
	 * 根据sql查询出实体bean对象
	 */
	@SuppressWarnings("unchecked")
	public List findSql(String sql, Class cls) {
		// TODO Auto-generated method stub
		return (List) dao.getHibernateSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(cls).list();
	}
	
	/**
	 * 创建数据库链接session
	 * @return
	 */
	public Session openSession(){
		return dao.getHibernateSessionFactory().openSession();
	}
	
	/**
	 * 根据sql查询出实体bean对象
	 */
	@SuppressWarnings("unchecked")
	public List findSqlWithOpenSession(Session session,String sql, Class cls) {
		// TODO Auto-generated method stub
			return session.createSQLQuery(sql).addEntity(cls).list();
	}
	/**
	 * 保存实体
	 * @param session
	 * @param obj
	 */
	public void save(Session session,Object obj){
		Transaction tx = session.beginTransaction(); 
		try{
			session.save(obj);
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			if(tx != null){
				tx.rollback();
			}
		}
	}
	
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
	@SuppressWarnings("unchecked")
	public List findSql(String sql, Object[] params, String[] orderBy, String[] order, int curPage, int pageSize,Class cls){
		final String queryString = setOrder(sql, orderBy, order);
		SQLQuery query = dao.getHibernateSessionFactory().getCurrentSession().createSQLQuery(queryString).addEntity(cls);
		setQueryParam(query, params);
		setPagination(query, curPage*pageSize, pageSize);
		return query.list();
	}
	/**
	 * jiang 查询结果转换为指定模型返回
	 * @param sql
	 * @param params
	 * @param orderBy
	 * @param order
	 * @param index
	 * @param size
	 * @param transformer
	 * 	结果转换器
	 * @return
	 */
	public List<?> findSQL(String sql, final Object[] params, final String[] orderBy, final String[] order, final int index, final int size, final ResultTransformer transformer) {
		return dao.findSQL(sql, params, orderBy, order, index*size, size, transformer);
	}
	
	/**
	 * 设置Query参数
	 * 
	 * @param query
	 *            Query
	 * @param params
	 *            查询参数
	 * @return
	 */
	private Query setQueryParam(Query query, Object[] params) {
		if (params == null) {
			return query;
		}
		for (int i = 0; i < params.length; i++) {
			/*
			 * select o from Object o where o.name like :name and age>=:age and
			 * id in(:id) 名称绑定参数 例:new Object[]{new Object[]{"name","张%"},new
			 * Object[]{"age",16},new Object[]{id,new Object[]{1,2,3,4,5}}}
			 */
			if (params[i] instanceof Object[]) {
				if (((Object[]) params[i]).length == 2 && ((Object[]) params[i])[0] instanceof String) {
					if (((Object[]) params[i])[1] instanceof Object[]) {
						query.setParameterList((String) ((Object[]) params[i])[0], (Object[]) ((Object[]) params[i])[1]);
					} else {
						query.setParameter((String) ((Object[]) params[i])[0], ((Object[]) params[i])[1]);
					}
				}
			} else {
				/*
				 * select o from Object o where o.name like ? and age>=? 占位符绑定参数
				 * 例:new Object[]{"张%",16}
				 */
				query.setParameter(i, params[i]);
			}
		}
		return query;
	}
	
	/**
	 * 设置分页
	 * 
	 * @param query
	 * @param index
	 *            首记录
	 * @param size
	 *            查询记录数
	 * @return
	 */
	private Query setPagination(Query query, int index, int size) {
		if (index > BaseDAO.NOFIRST) {
			query.setFirstResult(index);
		}
		if (size > BaseDAO.NOLIMIT) {
			query.setMaxResults(size);
		}
		return query;
	}
	/**
	 * 设置排序
	 * 
	 * @param sql
	 *            查询语句
	 * @param orderBy
	 *            排序字段
	 * @param order
	 *            书序
	 * @return
	 */
	private String setOrder(String sql, String[] orderBy, String[] order) {
		if (orderBy == null)
			return sql;
		if (orderBy != null && orderBy.length > 0) {
			StringBuffer sb = new StringBuffer(sql);
			sb.append(" order by ");
			for (int i = 0; i < orderBy.length; i++) {
				if (orderBy[i] != null && !orderBy[i].trim().equals("")) {
					if (order != null && order.length > i && "asc".equalsIgnoreCase(order[i])) {
						sb.append(orderBy[i]).append(" asc,");
					} else {
						sb.append(orderBy[i]).append(" desc,");
					}
				}
			}
			sql = sb.deleteCharAt(sb.length() - 1).toString();
		}
		return sql.toString();
	}
	
	
}
