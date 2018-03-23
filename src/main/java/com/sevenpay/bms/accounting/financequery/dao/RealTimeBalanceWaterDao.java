package com.sevenpay.bms.accounting.financequery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.financequery.bean.RealTimeBussBalanceWater;
import com.sevenpay.bms.accounting.financequery.bean.RealTimeCustBalanceWater;
import com.sevenpay.bms.accounting.financequery.mapper.RealTimeBalanceWaterMapper;
@Repository
public class RealTimeBalanceWaterDao {
	@Autowired
	private RealTimeBalanceWaterMapper mapper;
	
	@Page
	public List<RealTimeCustBalanceWater> selectCustBalanceWaterList(RealTimeCustBalanceWater queryBean){
		return mapper.selectCustBalanceWaterList(queryBean);
	}
	@Page
	public List<RealTimeBussBalanceWater> selectBussBalanceWaterList(RealTimeBussBalanceWater queryBean) {
		return mapper.selectBussBalanceWaterList(queryBean);
	}
	
}
