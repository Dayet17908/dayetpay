package com.sevenpay.bms.basemanager.merchant.bean;



import java.io.Serializable;

public class CashierInfo implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2131395679153030392L;

	private String onlyId;
	
	private String merchantCustId;
	
	private String cashierCustId;
	
	private String cashierMobile;

	private String cashierName;
	
	private String refundAuth;//是否有退款权限 0 否 ，1 是

	private String merchantName;
	
	private String userId;
	
	private String userName;
	
	private String createId;
	private String createName;
	private String createTime;
	
	private String modifyId;
	private String modifyName;
	private String modifyTime;
	/** 门店名称*/
	private String shopName;
	/** 是否有全门店权限*/
	private String queryAuth;
	
	/** 门店ID*/
	private String shopId;
	
	
	
	
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getQueryAuth() {
		return queryAuth;
	}

	public void setQueryAuth(String queryAuth) {
		this.queryAuth = queryAuth;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getModifyName() {
		return modifyName;
	}

	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getRefundAuth() {
		return refundAuth;
	}

	public void setRefundAuth(String refundAuth) {
		this.refundAuth = refundAuth;
	}

	public String getOnlyId() {
		return onlyId;
	}

	public void setOnlyId(String onlyId) {
		this.onlyId = onlyId;
	}

	public String getMerchantCustId() {
		return merchantCustId;
	}

	public void setMerchantCustId(String merchantCustId) {
		this.merchantCustId = merchantCustId;
	}

	public String getCashierCustId() {
		return cashierCustId;
	}

	public void setCashierCustId(String cashierCustId) {
		this.cashierCustId = cashierCustId;
	}

	public String getCashierMobile() {
		return cashierMobile;
	}

	public void setCashierMobile(String cashierMobile) {
		this.cashierMobile = cashierMobile;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	
}
