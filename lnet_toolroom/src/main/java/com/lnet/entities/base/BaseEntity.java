
package com.lnet.entities.base;


/**
 * 基础实体
 * 新增和修改以及删除都要更新最后更新操作信息
 * @author nonoyet
 * 2016-11-25
 */
public class BaseEntity {
	
	private Long     id ;
	private String   comments ;	    //备注
	
	//数据创建信息
	private Long     creatorAccountId;		//创建人账号表表id
	private String	 creatorAccountName;	//创建人帐号名
	private String   creatorTime;			//创建时间（YYYY-MM-dd hh:mm:ss）
	private String   creatorIP;				//创建人IP
	
	//均记录最后一次操作,详细操作查流程表(该操作包含录入和删除)
	private String   operatorType;			//操作类型代码
	private String   operatorTypeName;		//操作类型名称
	private Long 	 operatorAccountId;		//操作人账号id
	private String 	 operatorAccountName;	//操作账号名
	private String 	 operatorTime;			//操作时间（YYYY-MM-dd hh:mm:ss）
	private String   operatorIP;			//操作人IP
	
	//数据删除信息
	private String	 deleterFlag="0";		//删除标志
	private Long     deleterAccountId;		//删除人账号表id
	private String	 deleterAccountName;	//删除账号名
	private String   deleterTime;			//删除时间（YYYY-MM-dd hh:mm:ss）
	private String   deleterIP;				//删除人IP
	private String	 deleterReason;			//删除原因
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getCreatorAccountId() {
		return creatorAccountId;
	}
	public void setCreatorAccountId(Long creatorAccountId) {
		this.creatorAccountId = creatorAccountId;
	}
	public String getCreatorTime() {
		return creatorTime;
	}
	public void setCreatorTime(String creatorTime) {
		this.creatorTime = creatorTime;
	}
	public String getCreatorIP() {
		return creatorIP;
	}
	public void setCreatorIP(String creatorIP) {
		this.creatorIP = creatorIP;
	}
	public String getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}
	public String getOperatorTypeName() {
		return operatorTypeName;
	}
	public void setOperatorTypeName(String operatorTypeName) {
		this.operatorTypeName = operatorTypeName;
	}
	public Long getOperatorAccountId() {
		return operatorAccountId;
	}
	public void setOperatorAccountId(Long operatorAccountId) {
		this.operatorAccountId = operatorAccountId;
	}
	public String getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(String operatorTime) {
		this.operatorTime = operatorTime;
	}
	public String getOperatorIP() {
		return operatorIP;
	}
	public void setOperatorIP(String operatorIP) {
		this.operatorIP = operatorIP;
	}
	public String getDeleterFlag() {
		return deleterFlag;
	}
	public void setDeleterFlag(String deleterFlag) {
		this.deleterFlag = deleterFlag;
	}
	public Long getDeleterAccountId() {
		return deleterAccountId;
	}
	public void setDeleterAccountId(Long deleterAccountId) {
		this.deleterAccountId = deleterAccountId;
	}
	public String getDeleterAccountName() {
		return deleterAccountName;
	}
	public void setDeleterAccountName(String deleterAccountName) {
		this.deleterAccountName = deleterAccountName;
	}
	public String getDeleterTime() {
		return deleterTime;
	}
	public void setDeleterTime(String deleterTime) {
		this.deleterTime = deleterTime;
	}
	public String getDeleterIP() {
		return deleterIP;
	}
	public void setDeleterIP(String deleterIP) {
		this.deleterIP = deleterIP;
	}
	public String getDeleterReason() {
		return deleterReason;
	}
	public void setDeleterReason(String deleterReason) {
		this.deleterReason = deleterReason;
	}
	public void setCreatorAccountName(String creatorAccountName) {
		this.creatorAccountName = creatorAccountName;
	}
	public String getCreatorAccountName() {
		return creatorAccountName;
	}
	public void setOperatorAccountName(String operatorAccountName) {
		this.operatorAccountName = operatorAccountName;
	}
	public String getOperatorAccountName() {
		return operatorAccountName;
	}

}
