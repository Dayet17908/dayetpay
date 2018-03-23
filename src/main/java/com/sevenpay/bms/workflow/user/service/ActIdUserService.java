package com.sevenpay.bms.workflow.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.workflow.user.bean.ActIdUser;
import com.sevenpay.bms.workflow.user.dao.ActIdUserDao;

@Service
public class ActIdUserService {
	
	@Autowired
	private ActIdUserDao actIdUserDao;
	
	public List<ActIdUser> selectListActUser(ActIdUser record){
		
		return actIdUserDao.selectListActUser(record);
		
	}
}
