package com.sevenpay.bms.meeting.helper;

import org.apache.commons.lang3.StringUtils;
import org.gyzb.platform.common.utils.SpringUtils;

import com.sevenpay.bms.accounting.utils.DictionaryUtils;
import com.sevenpay.bms.meeting.MeetingConstant;

public class MeetingHelper {
	
//	public static boolean isPermit(int activityId) {
//		String ips = SpringUtils.getBean(DictionaryUtils.class).getDataValueByPath(MeetingConstant.IP_FILTERS_KEYWORD);
//		
//		if(StringUtils.isNotBlank(ips) && !(WebUtils.getHttpServletRequest().getRemoteAddr().indexOf(ips) != -1)) {
//			return false;
//		}
//		
//		return true;
//	}
	
	public static int getActivityId() {
		String activityId = SpringUtils.getBean(DictionaryUtils.class).getDataValueByPath(MeetingConstant.ACTIVITY_ID_KEYWORD);
		if(StringUtils.isNotBlank(activityId)) {
			return Integer.valueOf(activityId);
		}
		return 0;
	}
	
	public static String getEnvironment() {
		String environment = SpringUtils.getBean(DictionaryUtils.class).getDataValueByPath(MeetingConstant.MESSAGE_CONTENT_ENVIRONMENT);
		if(StringUtils.isNotBlank(environment)) {
			return environment;
		}
		return MeetingConstant.MESSAGE_TO_ALL;
	}
}
