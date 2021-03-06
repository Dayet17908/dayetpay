package com.sevenpay.bms.accounting.acctingworkdate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sevenpay.bms.accounting.acctingworkdate.bean.AcctWorkDate;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface AcctWorkDateMapper {

	List<AcctWorkDate> queryAcctWorkDatList(AcctWorkDate queryBean);

	AcctWorkDate selectWorkDateHis(@Param("workDate") String workDate);

	int insertWorkDateHis(AcctWorkDate insertBean);

	void deleteWorkDate();

	int insertWorkDate(AcctWorkDate updateBean);

	int updateWorkDateHis(@Param("workDate") String workDate);

}
