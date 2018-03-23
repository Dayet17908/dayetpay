package com.sevenpay.bms.expresspay.tradeResult.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.expresspay.mpper.JgkjTradeMapper;
import com.sevenpay.bms.expresspay.tradeResult.bean.JgkjTrade;

@Repository
public class JgkjTradeDao {
	@Autowired
	private JgkjTradeMapper jgkjTradeMapper;
	@Page
	public List<JgkjTrade> queryJgkjTradeList(JgkjTrade queryBean) {
		return jgkjTradeMapper.queryJgkjTradeList(queryBean);
	}
}
