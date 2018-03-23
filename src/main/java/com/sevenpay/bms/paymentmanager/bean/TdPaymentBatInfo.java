package com.sevenpay.bms.paymentmanager.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TdPaymentBatInfo implements Serializable{

	/**
	 * 批次号（日期YYYYMMDD+序列组成）
	 */
	private String batNo = null;

	/**
	 * 付款账号
	 */
	private String paerAcctNo = null;
	/**
	 * 总金额
	 */
	private String sumAmt = null;
	/**
	 * 成功总金额
	 */
	private String succAmt = null;
	/**
	* 
	*/
	private String sumCount = null;
	
	/**
	 * 成功笔数
	 */
	private String succCount = null;
	/**
	 * 失败总金额
	 */
	private String failAmt = null;
	/**
	 * 失败笔数
	 */
	private String failCount = null;
	/**
	 * 处理状态：01 未提交；02 已提交；03 银行处理中；00 银行处理完成
	 */
	private String batStatus = null;
	
	/**
	 * 创建时间
	 */
	private String createTime = null;
	/**
	 * 创建人
	 */
	private String createId = null;
	
	/**
	 * 修改人
	 */
	private String modifyId = null;
	/**
	 * 修改时间
	 */
	private String modifyTime = null;

	
	private String endCreateTime = null;
	
	public String getBatNo() {
		return batNo;
	}

	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}

	public String getPaerAcctNo() {
		return paerAcctNo;
	}

	public void setPaerAcctNo(String paerAcctNo) {
		this.paerAcctNo = paerAcctNo;
	}

	public String getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(String sumAmt) {
		this.sumAmt = sumAmt;
	}
	public String getSuccAmt() {
		return succAmt;
	}

	public void setSuccAmt(String succAmt) {
		this.succAmt = succAmt;
	}

	public String getSumCount() {
		return sumCount;
	}

	public void setSumCount(String sumCount) {
		this.sumCount = sumCount;
	}

	
	public String getSuccCount() {
		return succCount;
	}

	public void setSuccCount(String succCount) {
		this.succCount = succCount;
	}

	public String getFailAmt() {
		return failAmt;
	}

	public void setFailAmt(String failAmt) {
		this.failAmt = failAmt;
	}

	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}

	public String getBatStatus() {
		return batStatus;
	}

	public void setBatStatus(String batStatus) {
		this.batStatus = batStatus;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getModifyId() {
		return modifyId;
	}

	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

}
