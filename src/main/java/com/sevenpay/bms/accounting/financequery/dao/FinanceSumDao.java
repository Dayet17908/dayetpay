package com.sevenpay.bms.accounting.financequery.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.financequery.bean.FinanceSum;
import com.sevenpay.bms.accounting.financequery.mapper.FinanceSumMapper;

@Repository
public class FinanceSumDao {
	@Autowired
	private FinanceSumMapper mapper;
	@Page
	public List<FinanceSum> selectFinanceList(String subjectName){
		return mapper.selectFinanceList(subjectName);
	}
}
