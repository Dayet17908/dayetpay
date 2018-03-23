package com.sevenpay.bms.meeting.activity.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.meeting.activity.bean.ActivityBean;
import com.sevenpay.bms.meeting.activity.mapper.ActivityMapper;

@Repository
public class ActivityDao {
	@Autowired
	private ActivityMapper activityMapper;

	@Page
	public List<ActivityBean> selectActivityList(ActivityBean queryBean) {
		return activityMapper.selectActivityList(queryBean);
	}

}
