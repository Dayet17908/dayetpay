package com.sevenpay.bms.accounting.aggregations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultEqual;
import com.sevenpay.bms.accounting.aggregations.bean.BalAggregationResultException;
import com.sevenpay.bms.accounting.aggregations.dao.AggregationResultExceptionDAO;


@Service
public class AggregationResultExceptionService {

	
	@Autowired
	private AggregationResultExceptionDAO aggregationResultExceptionDAO;

	/**
	 * 差錯報表
	 * @param queryBean
	 * @return
	 */
	public List<BalAggregationResultException> selectErrorList(
			BalAggregationResultException queryBean) {
		
		return aggregationResultExceptionDAO.selectErrorList(queryBean);
	}

	/**
	 * 一致報表
	 * @param queryBean
	 * @return
	 */
	public List<BalAggregationResultEqual> selectFitList(
			BalAggregationResultEqual queryBean) {
	
		return aggregationResultExceptionDAO.selectFitList(queryBean);
	}
}
