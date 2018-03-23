package com.sevenpay.bms.myworkspace.allTask.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.myworkspace.allTask.bean.AllTaskBean;
import com.sevenpay.bms.myworkspace.allTask.dao.AllTaskDAO;
import com.sevenpay.bms.myworkspace.allTask.mapper.AllTaskMapper;

@Service
public class AllTaskService {

	@Autowired
	private AllTaskDAO allTaskDAO;
	
	@Autowired
	private AllTaskMapper allTaskMapper;
	
	public List<AllTaskBean> getAllTask(String userId){
		return allTaskDAO.getAllTask(userId);
	}
	
	
	public AllTaskBean getTaskByTaskId(String taskId) {
		return allTaskMapper.getTaskById(taskId);
	}
	
	public List<AllTaskBean> getAllTaskByRole(Map<String,Object> params){
		
		return allTaskDAO.getAllTaskbyRole(params);
		
	}
	
	public List<AllTaskBean> getTasks(AllTaskBean bean){
		return allTaskDAO.getTasks(bean);
	}
	
	
}
