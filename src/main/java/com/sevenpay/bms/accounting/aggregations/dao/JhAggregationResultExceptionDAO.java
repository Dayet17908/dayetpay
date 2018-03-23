package com.sevenpay.bms.accounting.aggregations.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.aggregations.bean.JhAggregationResultException;
import com.sevenpay.bms.accounting.aggregations.mapper.JhAggregationResultExceptionMapper;

@Repository
public class JhAggregationResultExceptionDAO {

	@Autowired
	private JhAggregationResultExceptionMapper jhAggregationResultExceptionMapper;
	
	@Page
	public List<JhAggregationResultException> selectJhResultExceptionList(
			JhAggregationResultException jhAggregationResultException) {
		return jhAggregationResultExceptionMapper.selectJhResultExceptionList(jhAggregationResultException);
	}

	

}
