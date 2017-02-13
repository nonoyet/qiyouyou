package com.lnet.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页实体
 * @author yangjm
 *
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -5536675518695146874L;

	/** 总记录数 */
	private int totalRecord;
	/** 结果集 */
	private List<Map<String, Object>> recordList;

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

}
