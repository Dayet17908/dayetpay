package com.sevenpay.bms.accounting.financequery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.financequery.bean.QueryWaterVo;
import com.sevenpay.bms.accounting.financequery.mapper.QueryWaterMapper;

@Repository
public class QueryWaterDao {
	@Autowired
	private QueryWaterMapper mapper;
	@Page
	public List<QueryWaterVo>selectQueryWaterList(QueryWaterVo waterVo){
		return mapper.selectQueryWaterList(waterVo);
	}
}
