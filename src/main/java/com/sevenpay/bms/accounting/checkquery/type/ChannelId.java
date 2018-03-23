package com.sevenpay.bms.accounting.checkquery.type;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;

/**
 * @project sevenpay-bms-web
 * @fileName ChannelId.java
 * @author huiquan.ma
 * @date 2015年10月16日
 * @memo 
 */
public enum ChannelId {
	
	@Description("中信")
	CNCB,
	@Description("银联")
	UNIONPAY,
	@Description("交广科技")
	JGKJ;
	
	
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


