package com.sevenpay.bms.meeting.prizewin.type;

import org.gyzb.platform.common.annotation.Comment;
import org.gyzb.platform.common.utils.ReflectUtils;

/**
 * @project sevenpay-bms-web
 * @fileName PrizeWinStatus.java
 * @author huiquan.ma
 * @date 2015年12月15日
 * @memo 
 */
public enum PrizeWinStatus {
	
	@Comment(desc="待领取")
	WAIT_RECEIVE,
	
	@Comment(desc="已领取")
	HAVE_RECEIVED,
	
	@Comment(desc="已收回")
	TAKE_BACK,
	
	@Comment(desc="无效")
	DISABLE;
	
	public String getDesc() {
		return ReflectUtils.getDesc(this);
	}
}


