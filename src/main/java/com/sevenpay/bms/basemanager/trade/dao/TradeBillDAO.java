package com.sevenpay.bms.basemanager.trade.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.trade.bean.AllTradeBill;
import com.sevenpay.bms.basemanager.trade.bean.TdTradeBillMainVO;
import com.sevenpay.bms.basemanager.trade.mapper.AllTradeBillMapper;
import com.sevenpay.bms.basemanager.trade.mapper.TdTradeBillMainMapper;

@Repository
public class TradeBillDAO {
	
	@Autowired
	private TdTradeBillMainMapper tdTradeBillMainMapper;
	
	@Autowired
	private AllTradeBillMapper allTradeBillMapper;
	/**
	 * 交易汇总
	 * @param tdTradeBillMainVO
	 * @return
	 */
	@Page
	public List<TdTradeBillMainVO> selectTdradeBillMainSummary(TdTradeBillMainVO tdTradeBillMainVO){
		return tdTradeBillMainMapper.selectTdradeBillMainSummary(tdTradeBillMainVO);
	}
	
	/**
	 * 查询消费流水
	 * @param tdTradeBillMainVO
	 * @return
	 */
	@Page
	public List<TdTradeBillMainVO> selectConsume(TdTradeBillMainVO tdTradeBillMainVO){
		return tdTradeBillMainMapper.selectConsume(tdTradeBillMainVO);
	}

	@Page
	public List<AllTradeBill> getAllTradeBill(String bank,String payProd,String payChannel) {
		// TODO Auto-generated method stub
		return allTradeBillMapper.getAllTradeBill(bank,payProd,payChannel);
	}

	public List<AllTradeBill> getAllTradeBillExport(String bank,
			String payProd, String payChannel) {
		// TODO Auto-generated method stub
		return allTradeBillMapper.getAllTradeBillExport(bank,payProd,payChannel);
	}
	
}
