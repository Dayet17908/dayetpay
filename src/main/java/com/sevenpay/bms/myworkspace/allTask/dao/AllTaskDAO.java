package com.sevenpay.bms.myworkspace.allTask.dao;

import java.util.List;
import java.util.Map;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.myworkspace.allTask.bean.AllTaskBean;
import com.sevenpay.bms.myworkspace.allTask.mapper.AllTaskMapper;

@Repository
public class AllTaskDAO {
	
	@Autowired
	private AllTaskMapper allTaskMapper;
	
	@Page
	public List<AllTaskBean> getAllTask(String userId){
		return allTaskMapper.getAllTask(userId);
	}
	
	@Page
	public List<AllTaskBean> getAllTaskbyRole(Map<String,Object> params){
		return allTaskMapper.getAllTaskbyRole(params);
	}
	
	@Page
	public List<AllTaskBean> getTasks(AllTaskBean bean){
		return allTaskMapper.getTasks(bean);
	}
}
