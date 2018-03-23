package com.sevenpay.bms.merchant.reported.bean;

import java.io.Serializable;

public class CrInComeBean implements Serializable{

	private static final long serialVersionUID = -2144259700479599225L;
	
	private String id;
	
	private String custId;
	
	private String custType;
	
	private String merchantCode;
	
	private String mchName;
	
	private String mchShortName;
	
	private String categoryType;
	
	private String address;
	
	private String customerPhone;
	
	private String linkman;
	
	private String phone;
	
	private String email;
	
	private String operator;
	
	private String mchRole;
	
	private String operatorIdno;
	
	private String linenceNo;
	
	private String certifcateType;
	
	private String contractsType;
	
	private String type;
	
	private String name;
	
	private String bankCardNo;
	
	private String subBranchName;
	
	private String cardType;
	
	private String province;
	
	private String city;
	
	private String country;
	
	private String bankCode;
	
	private String idCardPath;
	
	private String businessPath;
	
	private String openAccountPath;
	
	private String doorPath;
	
	private String patchNo;
	
	private String channelNo;
	
	private String filingStatus;
	
	private String outMerchantCode;
	
	/**
	 * 结算卡号
	 */
	private String accountNo;
	
	/**
	 * 结算户名
	 */
	private String accountName;
	
	/**
	 * 联行号
	 */
	private String CNAPS;
	
	/**
	 * 营业执照有效期
	 */
	private String businessValidTime;
	
	/**
	 * 身份证有效期
	 */
	private String idCardValidTime;
	
	public String getIdCardValidTime() {
		return idCardValidTime;
	}

	public void setIdCardValidTime(String idCardValidTime) {
		this.idCardValidTime = idCardValidTime;
	}

	public String getBusinessValidTime() {
		return businessValidTime;
	}

	public void setBusinessValidTime(String businessValidTime) {
		this.businessValidTime = businessValidTime;
	}

	public String getOpenAccountPath() {
		return openAccountPath;
	}

	public void setOpenAccountPath(String openAccountPath) {
		this.openAccountPath = openAccountPath;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCNAPS() {
		return CNAPS;
	}

	public void setCNAPS(String cNAPS) {
		CNAPS = cNAPS;
	}

	public String getOutMerchantCode() {
		return outMerchantCode;
	}

	public void setOutMerchantCode(String outMerchantCode) {
		this.outMerchantCode = outMerchantCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getPatchNo() {
		return patchNo;
	}

	public void setPatchNo(String patchNo) {
		this.patchNo = patchNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getIdCardPath() {
		return idCardPath;
	}

	public void setIdCardPath(String idCardPath) {
		this.idCardPath = idCardPath;
	}

	public String getBusinessPath() {
		return businessPath;
	}

	public void setBusinessPath(String businessPath) {
		this.businessPath = businessPath;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getMchName() {
		return mchName;
	}

	public void setMchName(String mchName) {
		this.mchName = mchName;
	}

	public String getMchShortName() {
		return mchShortName;
	}

	public void setMchShortName(String mchShortName) {
		this.mchShortName = mchShortName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getMchRole() {
		return mchRole;
	}

	public void setMchRole(String mchRole) {
		this.mchRole = mchRole;
	}

	public String getOperatorIdno() {
		return operatorIdno;
	}

	public void setOperatorIdno(String operatorIdno) {
		this.operatorIdno = operatorIdno;
	}

	public String getLinenceNo() {
		return linenceNo;
	}

	public void setLinenceNo(String linenceNo) {
		this.linenceNo = linenceNo;
	}

	public String getCertifcateType() {
		return certifcateType;
	}

	public void setCertifcateType(String certifcateType) {
		this.certifcateType = certifcateType;
	}

	public String getContractsType() {
		return contractsType;
	}

	public void setContractsType(String contractsType) {
		this.contractsType = contractsType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getSubBranchName() {
		return subBranchName;
	}

	public void setSubBranchName(String subBranchName) {
		this.subBranchName = subBranchName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDoorPath() {
		return doorPath;
	}

	public void setDoorPath(String doorPath) {
		this.doorPath = doorPath;
	}
	
}
