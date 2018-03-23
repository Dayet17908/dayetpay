package com.sevenpay.bms.workflow.user.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.workflow.user.bean.ActIdUser;
import com.sevenpay.bms.workflow.user.mapper.ActIdUserMapper;

@Repository
public class ActIdUserDao {

	@Autowired
	private ActIdUserMapper actIdUserMapper;
	
	@Page
	public List<ActIdUser> selectListActUser(ActIdUser record){
		
		return actIdUserMapper.selectListActUser(record);
		
	}
}
