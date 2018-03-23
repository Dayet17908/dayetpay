package com.sevenpay.bms.accounting.subjectSummary.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.subjectSummary.bean.SubjectSummary;
import com.sevenpay.bms.accounting.subjectSummary.mapper.SubjectSummaryMapper;

@Repository
public class SubjectSummaryDao {
	@Autowired
	private SubjectSummaryMapper subjectSummaryMapper;

	@Page
	public List<SubjectSummary> selectSubjectSummary(SubjectSummary subjectSummary) {
		return subjectSummaryMapper.selectSubjectSummary(subjectSummary);
	}

}
