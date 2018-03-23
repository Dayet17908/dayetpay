package com.sevenpay.bms.accounting.aggregations.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultException;
import com.sevenpay.bms.accounting.aggregations.mapper.BalAggregationResultExceptionMapper;


@Repository
public class BalAggregationResultExceptionDAO {

	@Autowired
	private BalAggregationResultExceptionMapper balAggregationResultExceptionMapper;
	
	@Page
	public List<BalAggregationResultException> selectZxResultExceptionList(BalAggregationResultException balAggregationResultException){
		
		
		return balAggregationResultExceptionMapper .selectZxResultExceptionList(balAggregationResultException);
	
	}
}
