package com.lnet.entities.base;
/**
 * 账号
 * @author nonoyet
 *
 */
public class Account extends BaseEntity {
	private String remoteAddr;		//当前登录ip

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}
}
