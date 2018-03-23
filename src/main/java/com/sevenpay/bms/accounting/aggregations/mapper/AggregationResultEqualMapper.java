package com.sevenpay.bms.accounting.aggregations.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultEqual;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;

@MapperScanCombinedmaster
public interface AggregationResultEqualMapper {
	
	
	/**
	 * 一致表
	 * @param queryBean
	 * @return
	 */

	public List<BalAggregationResultEqual> selectFitList( BalAggregationResultEqual queryBean);

	
}
