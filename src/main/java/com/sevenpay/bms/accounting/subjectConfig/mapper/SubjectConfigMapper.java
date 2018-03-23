package com.sevenpay.bms.accounting.subjectConfig.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.subjectConfig.bean.SubjectConfig;
import com.sevenpay.bms.common.annotation.MapperScanCore;
@MapperScanCore
public interface SubjectConfigMapper {
	void updateSubjectConfig(SubjectConfig subjectConfig);

	List<SubjectConfig> selectSubjectConfig(SubjectConfig subjectConfig);

	void insertSubjectConfig(SubjectConfig subjectConfig);
	
	void deleteSubjectConfig(SubjectConfig subjectConfig);
}
