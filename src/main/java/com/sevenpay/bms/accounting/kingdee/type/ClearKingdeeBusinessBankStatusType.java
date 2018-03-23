package com.sevenpay.bms.accounting.kingdee.type;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;

public enum ClearKingdeeBusinessBankStatusType {
	
	@Description("空")
	A,
	
	@Description("银行处理中")
	B,
	
	@Description("银行交易成功")
	C,
	
	@Description("银行交易失败")
	D,
	
	@Description("银行交易未确认")
	E;
	
	public String getDesc(){
		Class<?> clasz = this.getClass();
		Field field = null;
		try {
			field = clasz.getField(this.name());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		Description description = field.getAnnotation(Description.class);
		
		if(description  == null){
			return null;
		}else{
			return description.value();
		}
		
	} 
}
