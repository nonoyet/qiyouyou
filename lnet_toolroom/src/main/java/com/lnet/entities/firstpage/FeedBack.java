package com.lnet.entities.firstpage;

import com.lnet.entities.base.BaseEntity;

/**
 * 用户反馈建议
 * @author nonoyet
 * 2016-12-01
 */
public class FeedBack extends BaseEntity{
	private String type;			//反馈类型：0-提供建议，1-网站bug
	private String feedMsg;			//反馈内容
	private String linkman;			//反馈人
	private String linkaddr;		//联系方式
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setFeedMsg(String feedMsg) {
		this.feedMsg = feedMsg;
	}
	public String getFeedMsg() {
		return feedMsg;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkaddr(String linkaddr) {
		this.linkaddr = linkaddr;
	}
	public String getLinkaddr() {
		return linkaddr;
	}
}
