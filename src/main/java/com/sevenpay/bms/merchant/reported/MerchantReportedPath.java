package com.sevenpay.bms.merchant.reported;

/**
 * @project sevenpay-bms-web
 * @fileName MerchantSettlePath.java
 * @author huiquan.ma
 * @date 2015年10月10日
 * @memo 
 */
public class MerchantReportedPath {

	public static final String BASE = "/merchant";

	/** 查询列表*/
	public static final String LIST = "/reported/reportedList";
	/** 导出报表*/
	public static final String EXPORT = "/reported/export";
	/**页面入口*/
	public static final String BMSREPORT="/reported/merchantReported";
	
	/** 查询户报备 *//*
	public final static String SELECTLIST = "/reported/merchantReported";*/
	
	/** 查询商户是否可报备*/
	public static final String CHECKMERCHANTREPORT="/reported/checkMerchantReport";
	
	/**查询商户渠道*/
	public static final String GETCHANNL="/reported/getChannl";
	
	/**提交报备*/
	public static final String GOTOREPORT="/reported/goToReport";
	
	public static final String QUERYCATEGORYINFO="/reported/queryCategoryInfo";
	
	/**
	 * 快付通类目
	 */
	public static final String KFTCATEGORYINFO ="/reported/categoryInfoKFT";
	
	
	
}


