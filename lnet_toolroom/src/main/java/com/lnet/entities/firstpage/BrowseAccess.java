package com.lnet.entities.firstpage;

import com.lnet.entities.base.BaseEntity;

/**
 * 访问浏览器类型
 * @author nonoyet
 * 2016-11-25
 */
public class BrowseAccess extends BaseEntity{
	private String deviceType;	//设备类型
	private String browseType;	//浏览器类型
	public void setBrowseType(String browseType) {
		this.browseType = browseType;
	}
	public String getBrowseType() {
		return browseType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceType() {
		return deviceType;
	}
	
	
}
