package com.sevenpay.bms.basemanager.recharge.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.basemanager.recharge.bean.RechargeBean;
import com.sevenpay.bms.basemanager.recharge.mapper.RechargeMapper;

@Repository
public class RechargeDAO {
	
	@Autowired
	private RechargeMapper rechargeMapper;
	
	@Page
	public List<RechargeBean> selectRecharge(RechargeBean recharge){
		
		return rechargeMapper.selectRecharge(recharge);
	}

}
