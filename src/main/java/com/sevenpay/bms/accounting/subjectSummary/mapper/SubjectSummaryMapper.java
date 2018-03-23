package com.sevenpay.bms.accounting.subjectSummary.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.subjectSummary.bean.SubjectSummary;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface SubjectSummaryMapper {

	List<SubjectSummary> selectSubjectSummary(SubjectSummary subjectSummary);

}
