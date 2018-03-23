package org.sevenpay.platform.web.scheduler.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.sevenpay.platform.web.scheduler.bean.SchedulerJob;
import org.sevenpay.platform.web.scheduler.mapper.SchedulerJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerJobDao {
	@Autowired
	private SchedulerJobMapper schedulerJobMapper;

	/**
	 * 角色查询
	 * @param role
	 * @return
	 */
	@Page
	public List<SchedulerJob> seleteSchedulerJob(SchedulerJob job){
		return schedulerJobMapper.seleteSchedulerJob(job);
	}
}
