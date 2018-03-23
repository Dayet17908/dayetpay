package com.sevenpay.bms.accounting.aggregations.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultException;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;

@MapperScanCombinedmaster
public interface AggregationResultExceptionMapper {
	
	
	/**
	 * 差錯表
	 * @param queryBean
	 * @return
	 */
	public List<BalAggregationResultException> selectErrorList(BalAggregationResultException queryBean) ;

	
}
