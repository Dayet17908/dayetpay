package com.sevenpay.bms.accounting.kingdee.type;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;


public enum ClearKingdeeBusinessType {

	@Description("个人提现")
	PERSONAL_WITHDRAW,
	@Description("商户结算")
	MERCHANT_SETTLE;
	
	/**	获取描述性内容	*/
	public String getDesc() {
		Class<?> clazz = this.getClass();
		Field filed = null;
		try {
			filed = clazz.getField(this.name());
		} catch (Exception e) {
		}
		Description description = filed.getAnnotation(Description.class);
		if (description == null) {
			return null;
		} else {
			return description.value();
		}
	}
}


