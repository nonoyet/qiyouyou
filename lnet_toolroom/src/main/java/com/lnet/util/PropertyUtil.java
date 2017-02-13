package com.lnet.util;

import com.lnet.common.config.QType;
import com.lnet.entities.base.Account;
import com.lnet.entities.base.BaseEntity;
import com.lnet.entities.base.QProcess;


/**
 * 属性设置工具
 * @author nonoyet             
 * @version 2015-12-01
 */
public class PropertyUtil {
	/**
	 * 设置创建相关属性
	 * @param account
	 * 		账号
	 * @param eneity
	 * 		当前实体
	 */
	public static void setCreateProperty(Account account,BaseEntity eneity){
		if(account != null){
			eneity.setCreatorAccountId(account.getId());
			eneity.setCreatorAccountName(account.getCreatorAccountName());
			eneity.setCreatorIP(account.getRemoteAddr());
		}
		eneity.setCreatorTime(DateUtils.getSystemDateTimeString());
	}
	
	/**
	 * 设置最后修改相关属性
	 * @param account
	 * 		账号
	 * @param eneity
	 * 		当前实体
	 * @param operatorType
	 * 		操作类型
	 * @param operatorTypeName
	 * 		操作类型名
	 */
	public static void setOperatorProperty(Account account,BaseEntity eneity,String operatorType,String operatorTypeName){
		if(account != null){
			eneity.setOperatorAccountId(account.getCreatorAccountId());
			eneity.setOperatorAccountName(account.getCreatorAccountName());
			eneity.setOperatorIP(account.getRemoteAddr());
		}
		eneity.setOperatorTypeName(operatorTypeName);
		eneity.setOperatorType(operatorType);
		eneity.setOperatorTime(DateUtils.getSystemDateTimeString());
	}
	
	/**
	 * 设置最后修改相关属性
	 * @param account
	 * 		账号
	 * @param eneity
	 */
	public static void setDeleterProperty(Account account,BaseEntity eneity,String deleterFalg,String deleterReason){
		if("0".equals(deleterFalg)){			//正常数据(清空删除信息)
			eneity.setDeleterAccountId(null);
			eneity.setDeleterAccountName(null);
			eneity.setDeleterIP(null);
			eneity.setDeleterFlag(deleterFalg);
			eneity.setDeleterReason(null);
			eneity.setDeleterTime(DateUtils.getSystemDateTimeString());
		}else if("1".equals(deleterFalg)){		//删除数据(填入删除信息)
			if(account != null){
				eneity.setDeleterAccountId(account.getCreatorAccountId());
				eneity.setDeleterAccountName(account.getCreatorAccountName());
				eneity.setDeleterIP(account.getRemoteAddr());
			}
			eneity.setDeleterFlag(deleterFalg);
			eneity.setDeleterReason(deleterReason);
			eneity.setDeleterTime(DateUtils.getSystemDateTimeString());
		}else{									//其他情况自己完善
			throw new IllegalArgumentException("非法参数：deleterFalg:你需要自己指定该参数的意义");
		}
	}
	/**
	 * 设置流程相关属性
	 * @param account
	 * 		账号
	 * @param process
	 * 		流程实体
	 * @param type
	 * 		流程类型
	 * @param typeName
	 * 		类型名
	 * @param tableId
	 * 		关联表id
	 * @param tableName
	 * 		关联表名
	 * @param descTableId
	 * 		目标表id
	 * @param descTableName
	 * 		目标表名
	 */
	public static void setProcess(Account account,QProcess process,String type,String typeName,Long tableId,String tableName,Long descTableId,String descTableName){
		setCreateProperty(account, process);
		setOperatorProperty(account, process, QType.process.type_Add, QType.process.type_Add_Name);
		
		process.setType(type);
		process.setTypeName(typeName);
		process.setTableId(tableId);
		process.setTableName(tableName);
		process.setDescTableId(descTableId);
		process.setDescTableName(descTableName);
	}
	
	
}
