package org.sevenpay.platform.web.scheduler.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.sevenpay.platform.web.scheduler.bean.SchedulerJob;
@MapperScan
public interface SchedulerJobMapper {

	public List<SchedulerJob> seleteSchedulerJob(SchedulerJob job) ;

	public void addSchedulerJob(SchedulerJob job);

	public void deleteSchedulerJob(SchedulerJob job);

	public void updateSchedulerJob(SchedulerJob job);

}
