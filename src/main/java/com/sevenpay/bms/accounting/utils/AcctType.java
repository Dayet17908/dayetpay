package com.sevenpay.bms.accounting.utils;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Comment;

public enum AcctType {
	/**
	 * CHARGE--充值；  CASH_O--提现；  TRANSF--转账；  PAYMEN--支付；  RETURN--退款；  CANCEL--回滚；
	 */ 
	
	@Comment(code = "REGISTER", desc = "注册")
	REGISTER,
	
	@Comment(code = "RECHARGE",desc="充值")
	RECHARGE,
	
	@Comment(code = "PAYMENT" ,desc="支付")
	PAYMENT,
	
	@Comment(code = "PAYMENT_REVOKE" ,desc="支付撤销")
	PAYMENT_REVOKE,
	
	@Comment(code = "PAYMENT_REFUND" ,desc="支付退款")
	PAYMENT_REFUND,
	
	@Comment(code = "WITHDRAW" ,desc="提现")
	WITHDRAW, 
	
	@Comment(code = "WITHDRAW_APPLY" ,desc="提现申请")
	WITHDRAW_APPLY, 
	
	@Comment(code = "WITHDRAW_REVOKE" ,desc="提现申请撤销")
	WITHDRAW_REVOKE, 
	
	@Comment(code = "REFUND" ,desc="退款")
	REFUND,
	
	@Comment(code = "RECHARGE_REVOKE" ,desc="充值撤销")
	RECHARGE_REVOKE,
	
	@Comment(code = "RECEIVE" ,desc="收款")
	RECEIVE,
	
	@Comment(code = "RECEIVE_REVOKE" ,desc="收款撤销")
	RECEIVE_REVOKE,
	
	@Comment(code = "FREEZE" ,desc="冻结")
	FREEZE,
	@Comment(code = "UNFREEZE" ,desc="解冻")
	UNFREEZE;
	
	
	
	
	
	
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
