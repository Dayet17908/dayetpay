package com.sevenpay.bms.accounting.financequery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.financequery.bean.CommerciaBalance;
import com.sevenpay.bms.accounting.financequery.mapper.CommerciaBalanceMapper;

@Repository
public class CommerciaBalanceDao {
	@Autowired
	private CommerciaBalanceMapper mapper;
	
	@Page
	public List<CommerciaBalance>selectCommerciaBalanceList(CommerciaBalance commerciaBalance){
		return mapper.selectCommerciaBalanceList(commerciaBalance);
	}
}
