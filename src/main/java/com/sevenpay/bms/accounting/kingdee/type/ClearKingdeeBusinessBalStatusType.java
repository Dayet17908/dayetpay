package com.sevenpay.bms.accounting.kingdee.type;

import java.lang.reflect.Field;

import org.gyzb.platform.common.annotation.Description;



/**
 * 金蝶对账状态
 * @author wulingtong
 *
 */
public enum ClearKingdeeBusinessBalStatusType {
	//TODO
	@Description("初始")
	INIT;
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
