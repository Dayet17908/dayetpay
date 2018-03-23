package com.sevenpay.bms.accounting.aggregations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultStatistic;
import com.sevenpay.bms.accounting.aggregations.bean.BaseChannel;
import com.sevenpay.bms.accounting.aggregations.dao.BalAggregationResultStatisticDAO;



@Service
public class AggregationResultStatisticService {
	
	@Autowired
	private BalAggregationResultStatisticDAO balAggregationResultStatisticDAO;
	
	public List<BalAggregationResultStatistic> selectList(BalAggregationResultStatistic balAggregationResultStatistic){
		
		return balAggregationResultStatisticDAO.selectList(balAggregationResultStatistic);		
	}
	
	public List<BaseChannel> queryBalBaseChannel() {
		
		return balAggregationResultStatisticDAO.queryBalBaseChannel();
	}
	
	
}

