package com.sevenpay.bms.accounting.financequery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.financequery.bean.UserBalance;
import com.sevenpay.bms.accounting.financequery.mapper.UserBalanceMapper;

@Repository
public class UserBalanceDao {
	@Autowired
	private UserBalanceMapper mapper;	
	@Page
	public List<UserBalance>selectUserBalanceList(UserBalance userBalance){
		return mapper.selectUserBalanceList(userBalance);
	} 
}
