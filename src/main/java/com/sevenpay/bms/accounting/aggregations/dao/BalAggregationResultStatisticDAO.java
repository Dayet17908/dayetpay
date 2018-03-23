package com.sevenpay.bms.accounting.aggregations.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultStatistic;
import com.sevenpay.bms.accounting.aggregations.bean.BaseChannel;
import com.sevenpay.bms.accounting.aggregations.mapper.BalAggregationResultStatisticMapper;



@Repository
public class BalAggregationResultStatisticDAO {
	
	@Autowired
	private BalAggregationResultStatisticMapper balAggregationResultStatisticMapper;
	
	@Page
	public List<BalAggregationResultStatistic> selectList(BalAggregationResultStatistic balAggregationResultStatistic) {
			
		return balAggregationResultStatisticMapper.selectList(balAggregationResultStatistic);
	}

	public List<BaseChannel> queryBalBaseChannel() {
		
		return balAggregationResultStatisticMapper.queryBalBaseChannel();
	}

	

}
