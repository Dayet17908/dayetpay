package com.sevenpay.bms.accounting.subjectConfig.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.subjectConfig.bean.SubjectConfig;
import com.sevenpay.bms.accounting.subjectConfig.mapper.SubjectConfigMapper;

@Repository
public class SubjectConfingDao {
	@Autowired
	private SubjectConfigMapper mapper;
	
	@Page
	public List<SubjectConfig> selectSubjectInfo(SubjectConfig subject) {
		return mapper.selectSubjectConfig(subject);
	}
}
