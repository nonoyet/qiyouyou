package com.lnet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.egf.common.util.SysConfigPropertyUtil;
import com.lnet.service.impl.CommonServiceImpl;
import com.lnet.util.SaveReturn;

/**
 * 
 * PageAction 分页需要继承的Action 
 * @author lihp
 * 2015-11-6
 * 
 */

public abstract class PageAction extends BaseAction {
	protected SysConfigPropertyUtil configUtil = SysConfigPropertyUtil.getInstance();

	private static final long serialVersionUID = -7868058221768083672L;
	/** 当前页数 */
	protected int curPage = 1;
	/** 每页记录数 */
	protected int pageSize = 10;
	/** 排序列名 */
	protected String sortName = "id";
	/** 排序方式 */
	protected String sortType = "desc";
	/** 查询记录结果 */
	protected List<Map<String, Object>> recordList;
	/** 总记录数 */
	protected int totalRecord;
	
	protected CommonServiceImpl commonService;
	
	protected String wordsNum;//显示字数
	
	protected String rowsNum;//显示行数
	
	protected Long fid;
	
	private String tf;		//显示默认图片的标示符
	
	protected SaveReturn saveReturn = new SaveReturn();
	/**
	 * @return the curPage
	 */
	public int getCurPage() {
		return curPage;
	}

	/**
	 * @param curPage the curPage to set
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the sortName
	 */
	public String getSortName() {
		return sortName;
	}

	/**
	 * @param sortName the sortName to set
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * @param sortType the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	/**
	 * @return the recordList
	 */
	public List<Map<String, Object>> getRecordList() {
		return recordList;
	}

	/**
	 * @param recordList the recordList to set
	 */
	public void setRecordList(List<Map<String, Object>> recordList) {
		this.recordList = recordList;
	}

	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public CommonServiceImpl getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonServiceImpl commonService) {
		this.commonService = commonService;
	}

	public SaveReturn getSaveReturn() {
		return saveReturn;
	}

	public void setSaveReturn(SaveReturn saveReturn) {
		this.saveReturn = saveReturn;
	}

	public String getWordsNum() {
		return wordsNum;
	}

	public void setWordsNum(String wordsNum) {
		this.wordsNum = wordsNum;
	}

	public String getRowsNum() {
		return rowsNum;
	}

	public void setRowsNum(String rowsNum) {
		this.rowsNum = rowsNum;
	}
	
	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getTf() {
		return tf;
	}

	public void setTf(String tf) {
		this.tf = tf;
	}

	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage(){
		return totalRecord/pageSize + (totalRecord%pageSize==0?0:1);
	}

	 /**
     * 通过PrintWriter向客户端输出信息
     * @param info Object 输出对象，建议使用String输出html信息
     */
    protected void printHtmlInfoToClient(Object info) {
    	
    	response.setContentType("text/html;charset=UTF8");
        try {
            PrintWriter out = response.getWriter();
            out.print(info);
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error("向客户端发出信息失败...", e);
        }
    }
  
	public SysConfigPropertyUtil getConfigUtil() {
		return configUtil;
	}

	public void setConfigUtil(SysConfigPropertyUtil configUtil) {
		this.configUtil = configUtil;
	}
    
}
