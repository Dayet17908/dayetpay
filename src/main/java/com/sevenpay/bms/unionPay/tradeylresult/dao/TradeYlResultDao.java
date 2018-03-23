package com.sevenpay.bms.unionPay.tradeylresult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.unionPay.tradeylresult.bean.TradeYlResut;
import com.sevenpay.bms.unionPay.tradeylresult.mapper.TradeYlResultMapper;

@Repository
public class TradeYlResultDao {
	
	@Autowired
	private TradeYlResultMapper tradeYlResultMapper;

	@Page
	public List<TradeYlResut> selectTransYlResut(TradeYlResut queryBean) {
		
		return tradeYlResultMapper.selectTransYlResut(queryBean);
	}
}
