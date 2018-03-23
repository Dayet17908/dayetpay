package org.sevenpay.platform.web.myWorkSpace.dao;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.gyzb.platform.common.utils.ThreadUtils;
import org.gyzb.platform.web.Constants;
import org.gyzb.platform.web.page.Page;
import org.gyzb.platform.web.page.bean.PageInfo;
import org.sevenpay.platform.web.myWorkSpace.bean.WaitTaskBean;
import org.sevenpay.platform.web.myWorkSpace.mapper.MyWorkSpaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkSpaceDAO {

	@Resource 
	private TaskService taskService;
	
	@Autowired
	private MyWorkSpaceMapper myWorkSpaceMapper;
	
	/**
	 * 查询我的代办任务
	 */
	@Page
	public List<Task> getTasks(String userId){
		
		PageInfo pageInfo = (PageInfo)ThreadUtils.get(Constants.Platform.$_PAGEINFO);
		
		TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee(userId);
		
		pageInfo.setRowCnt(new Long( taskQuery.count()).intValue());
			
		
		return taskQuery.listPage(pageInfo.getFirstIdx()-1, pageInfo.getPageSize());
	}
	
	@Page
	public List<WaitTaskBean> getMyTasks(WaitTaskBean bean){
		return myWorkSpaceMapper.getMyTasks(bean);
		
	}
}
