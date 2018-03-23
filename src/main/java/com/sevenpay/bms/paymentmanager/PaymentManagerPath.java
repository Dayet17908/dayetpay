package com.sevenpay.bms.paymentmanager;

/**
 * 代付管理路径
 * 
 * @project sevenpay-bms-web
 * @class PaymentManagerPath.class
 * @author chunhui.zeng
 * @date 2017年9月23日
 * @memo
 *
 */
public class PaymentManagerPath {

	/** 代付管理页面 */
	public final static String BASE = "/paymentmanager";
	/** 代付 */
	public final static String PAYMENT = "/payment";
	/** 批量代付 */
	public final static String PAYMENTLIST = "/paymentList";
	/** 文件上传 */
	public final static String FILEUPLOAD = "/fileUpload";
	/** 批量数据提交 */
	public final static String BATPAYMENTDATA = "/batpaymentdata";
	/** 数据修改 */
	public final static String UPDATE = "/update";

	/** 查询批量数据 */
	public final static String SELECTLIST = "/selectList";
	
	/** 查询批量数据状态 */
	public final static String STATUS = "/status";
	
	/** 查询批量失败数据 */
	public final static String FAILLIST = "/failPayment";
	
}
