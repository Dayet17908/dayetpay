package com.sevenpay.bms.accounting.subjectInfo.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.subjectInfo.bean.SubjectInfo;
import com.sevenpay.bms.accounting.subjectInfo.mapper.SubjectInfoMapper;


@Repository
public class SubjectInfoDao {

	@Autowired
	private SubjectInfoMapper subjectInfoMapper;
	@Page
	public List<SubjectInfo> selectSubjectInfo(SubjectInfo subject) {
		return subjectInfoMapper.selectSubjectInfo(subject);
	}
	
	public List<SubjectInfo> list(){
		return subjectInfoMapper.list();
	}
}
