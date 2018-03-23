package com.sevenpay.bms.basemanager.tradeControl.Dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.tradeControl.bean.TradeControl;
import com.sevenpay.bms.basemanager.tradeControl.mapper.TradeControlMapper;

@Repository
public class TradeControlDAO {
	
	@Autowired
	private TradeControlMapper tradeContrlMapper;
	
	@Page
	public List<TradeControl> selectAll(TradeControl tradeControl){
		return tradeContrlMapper.selectAll(tradeControl);
	}
}
