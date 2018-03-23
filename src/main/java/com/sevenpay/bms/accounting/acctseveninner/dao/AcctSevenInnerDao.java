package com.sevenpay.bms.accounting.acctseveninner.dao;

import java.util.List;

import org.gyzb.platform.web.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenpay.bms.accounting.acctseveninner.bean.AcctSevenInner;
import com.sevenpay.bms.accounting.acctseveninner.mapper.AcctSevenInnerMapper;

@Repository
public class AcctSevenInnerDao {
	@Autowired
	private AcctSevenInnerMapper acctSevenInnerMapper;

	@Page
	public List<AcctSevenInner> queryAcctSevenInnerList(AcctSevenInner queryBean) {
		return acctSevenInnerMapper.queryAcctSevenInnerList(queryBean);
	}

}
