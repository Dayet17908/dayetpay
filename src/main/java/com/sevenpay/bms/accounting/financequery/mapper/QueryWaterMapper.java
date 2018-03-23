package com.sevenpay.bms.accounting.financequery.mapper;

import java.util.List;

import com.sevenpay.bms.accounting.financequery.bean.QueryWaterVo;
import com.sevenpay.bms.common.annotation.MapperScanCore;

@MapperScanCore
public interface QueryWaterMapper {
	List<QueryWaterVo>selectQueryWaterList(QueryWaterVo waterVo);
}
