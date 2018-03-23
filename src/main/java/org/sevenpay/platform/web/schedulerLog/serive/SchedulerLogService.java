package org.sevenpay.platform.web.schedulerLog.serive;

import java.util.List;

import org.sevenpay.platform.web.schedulerLog.bean.SchedulerLog;
import org.sevenpay.platform.web.schedulerLog.dao.SchedulerLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerLogService {
	@Autowired
	private SchedulerLogDao dao;
	
	public List<SchedulerLog>selectSchedulerLogList(SchedulerLog schedulerLog){
		return dao.selectSchedulerLogList(schedulerLog);
	}
}
