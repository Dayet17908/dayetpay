package com.sevenpay.bms.accounting.aggregations.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultStatistic;
import com.sevenpay.bms.accounting.aggregations.bean.BaseChannel;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;

@MapperScanCombinedmaster 
public interface BalAggregationResultStatisticMapper {
	
	List<BalAggregationResultStatistic> selectList(BalAggregationResultStatistic requestBean);

	List<BaseChannel> queryBalBaseChannel();
}