package com.sevenpay.bms.paymentmanager.bean;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class TdPaymentBatDetail implements Serializable {

	

	/**
	 * 批次号
	 */
	private String batNo = null;
	/**
	 * 序号
	 */
	private String rowNo = null;
	/**
	 * 收款人
	 */
	private String recAccountName = null;
	/**
	 * 收款人账号
	 */
	private String recAccountNo = null;
	/**
	 * 收款人银行号/银行名称
	 */
	private String recBankCode = null;
	/**
	 * 收款人联连号
	 */
	private String recBankCnaps = null;
	/**
	 * 收款金额
	 */
	private String transAmt = null;
	/**
	 * 处理状态
	 */
	private String status = null;
	/**
	 * 处理情况摘要
	 */
	private String procMemo = null;
	/**
	 * 创建人
	 */
	private String createId = null;
	/**
	 * 创建时间
	 */
	private String createTime = null;
	/**
	 * 修改人
	 */
	private String modifyId = null;
	/**
	 * 修改时间
	 */
	private String modifyTime = null;
	
	private String endCreateTime;

	private BigDecimal transAmtCount = null;
	
	/**
	 * 收款人银行名称
	 */
	private String payeeAcctBankName = null;
	
	public String getBatNo() {
		return batNo;
	}

	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public String getRecAccountName() {
		return recAccountName;
	}

	public void setRecAccountName(String recAccountName) {
		this.recAccountName = recAccountName;
	}

	public String getRecAccountNo() {
		return recAccountNo;
	}

	public void setRecAccountNo(String recAccountNo) {
		this.recAccountNo = recAccountNo;
	}

	public String getRecBankCode() {
		return recBankCode;
	}

	public void setRecBankCode(String recBankCode) {
		this.recBankCode = recBankCode;
	}

	public String getRecBankCnaps() {
		return recBankCnaps;
	}

	public void setRecBankCnaps(String recBankCnaps) {
		this.recBankCnaps = recBankCnaps;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProcMemo() {
		return procMemo;
	}

	public void setProcMemo(String procMemo) {
		this.procMemo = procMemo;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getPayeeAcctBankName() {
		return payeeAcctBankName;
	}

	public void setPayeeAcctBankName(String payeeAcctBankName) {
		this.payeeAcctBankName = payeeAcctBankName;
	}

	public BigDecimal getTransAmtCount() {
		return transAmtCount;
	}

	public void setTransAmtCount(BigDecimal transAmtCount) {
		this.transAmtCount = transAmtCount;
	}

}
