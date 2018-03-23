package com.sevenpay.bms.accounting.aggregations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultException;
import com.sevenpay.bms.accounting.aggregations.dao.BalAggregationResultExceptionDAO;

@Service
public class BalAggregationResultExceptionService {

	
	@Autowired
	private BalAggregationResultExceptionDAO balAggregationResultExceptionDAO;
	
	public List<BalAggregationResultException> selectZxResultExceptionList(BalAggregationResultException balAggregationResultException){
		
		return balAggregationResultExceptionDAO.selectZxResultExceptionList(balAggregationResultException);		
	}
}
