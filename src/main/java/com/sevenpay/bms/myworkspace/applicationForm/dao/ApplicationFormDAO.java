package com.sevenpay.bms.myworkspace.applicationForm.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.myworkspace.applicationForm.bean.ApplicationFormBean;
import com.sevenpay.bms.myworkspace.applicationForm.mapper.ApplicationFormMapper;

@Repository
public class ApplicationFormDAO {
	
	@Autowired
	private ApplicationFormMapper applicationFormMapper;
	
	@Page
	public List<ApplicationFormBean> getApplicationForm(ApplicationFormBean bean){
		
		return applicationFormMapper.getApplicationForm(bean);
	}
}
