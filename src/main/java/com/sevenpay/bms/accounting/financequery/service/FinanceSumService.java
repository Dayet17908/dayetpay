package com.sevenpay.bms.accounting.financequery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevenpay.bms.accounting.financequery.bean.FinanceSum;
import com.sevenpay.bms.accounting.financequery.dao.FinanceSumDao;

@Service
public class FinanceSumService {
	@Autowired
	private FinanceSumDao dao;

	public List<FinanceSum> selectFinanceList(String subjectName) {
		return dao.selectFinanceList(subjectName);
	}
	
}
