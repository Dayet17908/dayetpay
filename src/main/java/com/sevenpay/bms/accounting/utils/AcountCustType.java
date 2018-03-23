package com.sevenpay.bms.accounting.utils;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Comment;

public enum AcountCustType {

	/**
	 * 银行-客户借记账户
	 */
	@Comment(code = "BANK_CUS_0", desc = "银行-客户借记账户")
	BANK_CUS_0,

	/**
	 * 银行-客户贷记账户
	 */
	@Comment(code = "BANK_CUS_1", desc = "银行-客户贷记账户")
	BANK_CUS_1,

	/**
	 * 银行-七分钱账户
	 */
	@Comment(code = "BANK_SEV_0", desc = "银行-七分钱账户")
	BANK_SEV_0,

	/**
	 * 银行-七分宝账户
	 */
	@Comment(code = "BANK_QFB_0", desc = "银行-七分宝账户")
	BANK_QFB_0,

	/**
	 * SEVN_CUS_0--七分钱-客户账户
	 */
	@Comment(code = "SEVN_CUS_0", desc = "七分钱-客户账户")
	SEVN_CUS_0,

	/**
	 * SEVN_SEV_0--七分钱-七分钱账户
	 */
	@Comment(code = "SEVN_SEV_0", desc = "七分钱-七分钱账户")
	SEVN_SEV_0,
	/**
	 * SEVN_SEV_1--七分钱-七分钱担保账户
	 */
	@Comment(code = "SEVN_SEV_1", desc = "七分钱-七分钱担保账户")
	SEVN_SEV_1,
	/**
	 * SEVN_SEV_2--七分钱-七分钱手续费账户
	 */
	@Comment(code = "SEVN_SEV_2", desc = "七分钱-七分钱手续费账户")
	SEVN_SEV_2,

	/**
	 * QFB0_CUS_0--七分宝-客户账户；
	 */
	@Comment(code = "QFB0_CUS_0", desc = "七分宝-客户账户")
	QFB0_CUS_0,
	/**
	 * QFB0_QFB_0--七分宝-七分宝账户；
	 */
	@Comment(code = "QFB0_QFB_0", desc = "七分宝-七分宝账户")
	QFB0_QFB_0,

	/**
	 * BANK_SEV_1--七分钱<担保>银行账户；
	 */
	@Comment(code = "BANK_SEV_1", desc = "七分钱<担保>银行账户")
	BANK_SEV_1,
	/**
	 * BANK_SEV_2--七分钱<手续费>银行账户；
	 */
	@Comment(code = "BANK_SEV_2", desc = "七分钱<手续费>银行账户")
	BANK_SEV_2;

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
