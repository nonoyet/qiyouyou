package com.lnet.entities.base;
/**
 * 流程表
 * @author nonoyet
 *
 */
public class QProcess extends BaseEntity {
	private String type;				//流程类型
	private String typeName;			//流程类型名			
	private Long tableId;				//关联表id
	private String tableName;			//关联表名
	
	private Long descTableId;			//目标表id
	private String descTableName;		//目标表名
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Long getDescTableId() {
		return descTableId;
	}
	public void setDescTableId(Long descTableId) {
		this.descTableId = descTableId;
	}
	public String getDescTableName() {
		return descTableName;
	}
	public void setDescTableName(String descTableName) {
		this.descTableName = descTableName;
	}
	
	
}
