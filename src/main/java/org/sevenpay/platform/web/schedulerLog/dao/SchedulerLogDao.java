package org.sevenpay.platform.web.schedulerLog.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.sevenpay.platform.web.schedulerLog.bean.SchedulerLog;
import org.sevenpay.platform.web.schedulerLog.mapper.SchedulerLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerLogDao {
	@Autowired
	private SchedulerLogMapper mapper;
	
	@Page
	public List<SchedulerLog>selectSchedulerLogList(SchedulerLog schedulerLog){
		return mapper.selectSchedulerLogList(schedulerLog);
	}
}
