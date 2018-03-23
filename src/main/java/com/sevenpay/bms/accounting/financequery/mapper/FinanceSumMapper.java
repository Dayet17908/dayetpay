package com.sevenpay.bms.accounting.financequery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sevenpay.bms.accounting.financequery.bean.FinanceSum;
import com.sevenpay.bms.common.annotation.MapperScanCore;
@MapperScanCore
public interface FinanceSumMapper {
	
	List<FinanceSum> selectFinanceList(@Param("subjectName") String subjectName );
}
