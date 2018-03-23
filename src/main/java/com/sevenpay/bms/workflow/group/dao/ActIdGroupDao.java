package com.sevenpay.bms.workflow.group.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.workflow.group.bean.ActIdGroup;
import com.sevenpay.bms.workflow.group.mapper.ActIdGroupMapper;

@Repository
public class ActIdGroupDao {

	@Autowired
	private ActIdGroupMapper actIdGroupMapper;
	
	@Page
	public List<ActIdGroup> selectListActIdGroup(ActIdGroup record){
		return actIdGroupMapper.selectListActIdGroup(record);
	}
}
