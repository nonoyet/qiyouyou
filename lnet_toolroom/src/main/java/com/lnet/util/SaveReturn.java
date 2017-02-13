package com.lnet.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 保存完后返回的对象，提示是否保存成功，以及返回相关数据供页面刷新<br>
 * 
 * @author redstorm
 * @version 2011-4-15
 * 
 */

public class SaveReturn {

	/**
	 * 是否保存成功的标志
	 */
	private boolean saveSuccess = true;
	
	private String callBack = "";	//自定义回调

	/**
	 * 保存失败时的错误信息
	 */
	private String saveErrorMessage = "";

	/**
	 * 新增时返回新增的主键
	 */
	private String saveID = "";

	/**
	 * 其他需要刷新到页面的集合
	 */
	private List<String> refreshList = new ArrayList<String>();

	public boolean isSaveSuccess() {
		return saveSuccess;
	}

	public void setSaveSuccess(boolean saveSuccess) {
		this.saveSuccess = saveSuccess;
	}

	public String getSaveErrorMessage() {
		return saveErrorMessage;
	}

	public void setSaveErrorMessage(String saveErrorMessage) {
		this.saveErrorMessage = StringUtils.nullToStr(saveErrorMessage);
	}

	public String getSaveID() {
		return saveID;
	}

	public void setSaveID(String saveID) {
		this.saveID = StringUtils.nullToStr(saveID);
	}

	public List<String> getRefreshList() {
		return refreshList;
	}

	public void setRefreshList(List<String> refreshList) {
		this.refreshList = refreshList;
	}

	/**
	 * 向刷新集合里新增一个值<br>
	 * 
	 * @param value
	 *            void
	 */
	public void addRefreshValue(String refreshValue) {
		refreshList.add(StringUtils.nullToStr(refreshValue));
	}

	public String getCallBack() {
		return callBack;
	}
	/**
	 * 设置自定义回调方法名(当返回为true时候调用)<br>
	 * eg:如setCallBack("doSuccess()")将会调用请求jsp页面的doSuccess js方法，
	 * 该方法可加入参数 ,可自定义方法名;
	 * @param callBack
	 */
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

}
