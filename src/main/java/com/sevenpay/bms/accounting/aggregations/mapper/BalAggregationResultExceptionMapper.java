package com.sevenpay.bms.accounting.aggregations.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultException;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;

@MapperScanCombinedmaster
public interface BalAggregationResultExceptionMapper {
	
	List<BalAggregationResultException> selectZxResultExceptionList(BalAggregationResultException balAggregationResultException);
	
}
