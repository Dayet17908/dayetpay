package com.sevenpay.bms.accounting.utils;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Comment;

public enum TransferTransType {
	/**
	 * 交易类型： ONL_TO_SEV--网银入账七分钱； CAD_TO_SEV--快捷支付至七分钱； SEV_TO_CAD--七分钱至银行卡；
	 * SEV_TO_SEV--七分钱至七分钱； SEV_TO_QFB--七分钱至七分宝； QFB_TO_SEV--七分宝至七分钱；
	 */
	/**
	 * 网银入账七分钱
	 */
	@Comment(code = "ONL_TO_SEV", desc = "网银入账七分钱")
	ONL_TO_SEV,
	/**
	 * 快捷支付至七分钱
	 */
	@Comment(code = "CAD_TO_SEV", desc = "快捷支付至七分钱")
	CAD_TO_SEV,

	/**
	 * 七分钱至银行卡
	 */
	@Comment(code = "SEV_TO_CAD", desc = "七分钱至银行卡")
	SEV_TO_CAD,
	/**
	 * 七分钱至七分钱
	 */
	@Comment(code = "SEV_TO_SEV", desc = "七分钱至七分钱")
	SEV_TO_SEV,

	/**
	 * 七分钱至七分宝
	 */
	@Comment(code = "SEV_TO_QFB", desc = "七分钱至七分宝")
	SEV_TO_QFB,
	/**
	 * 七分宝至七分钱
	 */
	@Comment(code = "QFB_TO_SEV", desc = "七分宝至七分钱")
	QFB_TO_SEV,
	/**
	 * 冻结
	 */
	@Comment(code = "FREEZE", desc = "冻结")
	FREEZE,
	/**
	 * 七分钱到手续费cgl
	 */
	@Comment(code = "CHARGE", desc = "七分钱到手续费cgl")
	CHARGE,
	/**
	 * 七分钱至七分钱担保
	 */
	@Comment(code = "SEV_TO_SEV1", desc = "七分钱至七分钱担保")
	SEV_TO_SEV1,
	/**
	 * 七分钱担保至七分钱
	 */
	@Comment(code = "SEV1_TO_SEV", desc = "七分钱担保至七分钱")
	SEV1_TO_SEV,
	/**
	 * 七分钱至七分钱费用
	 */
	@Comment(code = "SEV_TO_SEV2", desc = "七分钱至七分钱费用")
	SEV_TO_SEV2;

	/** 获取描述性内容 */
	public String getDesc() {
		Class<?> clazz = this.getClass();
		Field filed = null;
		try {
			filed = clazz.getField(this.name());
		} catch (Exception e) {
		}
		Comment code = filed.getAnnotation(Comment.class);
		if (code == null) {
			return null;
		} else {
			return code.desc();
		}
	}

	/** 获取编码 */
	public String getCode() {
		Class<?> clazz = this.getClass();
		Field filed = null;
		try {
			filed = clazz.getField(this.name());
		} catch (Exception e) {
		}
		Comment code = filed.getAnnotation(Comment.class);
		if (code == null) {
			return null;
		} else {
			return code.code();
		}
	}
}
