package com.sevenpay.bms.accounting.unnamedProcessing.clearjgkjtrade.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.unnamedProcessing.clearjgkjtrade.bean.ClearJgkjTrade;
import com.sevenpay.bms.accounting.unnamedProcessing.clearjgkjtrade.mapper.ClearJgkjTradeMapper;

@Repository
public class ClearJgkjTradeDao {
	
	@Autowired
	private ClearJgkjTradeMapper mapper;
	@Page
	public List<ClearJgkjTrade> selectClearJgkjTradeList(ClearJgkjTrade clearJgkjTrade){
		return mapper.selectClearJgkjTradeList(clearJgkjTrade);
	}
}
