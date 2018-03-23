package com.sevenpay.bms.accounting.aggregations.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.aggregations.bean.JhAggregationResultException;
import com.sevenpay.bms.common.annotation.MapperScanCombinedmaster;


@MapperScanCombinedmaster
public interface JhAggregationResultExceptionMapper {

	List<JhAggregationResultException> selectJhResultExceptionList(
			JhAggregationResultException jhAggregationResultException);

	

	

}
