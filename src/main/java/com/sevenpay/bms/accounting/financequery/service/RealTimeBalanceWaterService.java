package com.sevenpay.bms.accounting.financequery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.financequery.bean.RealTimeBussBalanceWater;
import com.sevenpay.bms.accounting.financequery.bean.RealTimeCustBalanceWater;
import com.sevenpay.bms.accounting.financequery.dao.RealTimeBalanceWaterDao;

@Service
public class RealTimeBalanceWaterService {
	@Autowired
	private RealTimeBalanceWaterDao dao;
	
	public List<RealTimeCustBalanceWater> selectCustBalanceWaterList(RealTimeCustBalanceWater queryBean) {
		return dao.selectCustBalanceWaterList(queryBean);
		 
	}

	public List<RealTimeBussBalanceWater> selectBussBalanceWaterList(RealTimeBussBalanceWater queryBean) {
		return dao.selectBussBalanceWaterList(queryBean);
	}

}
